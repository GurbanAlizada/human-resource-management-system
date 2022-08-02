package com.example.service.impl;

import com.example.adapters.cloudinary.inter.CloudServiceInter;
import com.example.dtos.request.PhotoRequest;
import com.example.model.cv.Photo;
import com.example.repository.PhotoRepository;
import com.example.results.ErrorResult;
import com.example.results.Result;
import com.example.results.SuccessResult;
import com.example.service.inter.CandidateServiceInterr;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Service
public class PhotoServiceImpl {


    private final PhotoRepository photoRepository;
    private final CloudServiceInter cloudServiceInter;
    private final CandidateServiceInterr candidateServiceInterr;


    public PhotoServiceImpl(PhotoRepository photoRepository,
                            CloudServiceInter cloudServiceInter ,
                            CandidateServiceInterr candidateServiceInterr) {
        this.photoRepository = photoRepository;
        this.cloudServiceInter = cloudServiceInter;
        this.candidateServiceInterr =candidateServiceInterr;
    }



    public List<Photo> getAll() {
        return photoRepository.findAll();
    }


    public String add(PhotoRequest photoRequest) {
        Photo photo = Photo.builder()
                .url(photoRequest.getUrl())
                .publicId(photoRequest.getPublicId())
                .candidate(candidateServiceInterr.getById(photoRequest.getCandidateId()))
                .build();
        photoRepository.save(photo);
        return "Photo added";
    }




    public Result addPhoto(MultipartFile multipartFile, int candidateId) {
        var result=this.cloudServiceInter.uploadImage(multipartFile);
        if(!result.isSuccess()) {
            return new ErrorResult(result.getMessage());
        }
        var candidate = this.candidateServiceInterr.getById(candidateId);
        Photo photo = new Photo();
        photo.setCandidate(candidate);
        photo.setUrl(result.getData().get("url"));
        photo.setPublicId(result.getData().get("public_id"));
        this.photoRepository.save(photo);
        return new SuccessResult("Fotograf eklendi");
    }








}
