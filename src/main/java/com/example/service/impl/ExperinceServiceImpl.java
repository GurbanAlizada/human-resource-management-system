package com.example.service.impl;

import com.example.dtos.request.ExperinceRequest;
import com.example.model.Cv;
import com.example.model.Education;
import com.example.model.Experince;
import com.example.repository.ExperinceRepository;
import com.example.service.inter.ExperinceServiceInter;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ExperinceServiceImpl implements ExperinceServiceInter {


    private final ExperinceRepository experinceRepository;
    private final CvServiceImpl cvService;

    public ExperinceServiceImpl(ExperinceRepository experinceRepository, CvServiceImpl cvService) {
        this.experinceRepository = experinceRepository;
        this.cvService = cvService;
    }

    public Experince addExperince(ExperinceRequest experinceRequest){
        Cv cv = cvService.getById(experinceRequest.getCvId());
        Experince experince = Experince.builder()
                .companyName(experinceRequest.getCompanyName())
                .departmentName(experinceRequest.getDepartmentName())
                .startingDate(experinceRequest.getStartingDate())
                .dateOfGraduation(experinceRequest.getDateOfGraduation())
                .cv(cv)
                .build();

        return experinceRepository.save(experince);
    }



    @Override
    public List<Experince> getAllBySorted(int id){
        Sort sort = Sort.by(Sort.Direction.DESC , "dateOfGraduation");
        List<Experince> experinces = experinceRepository.findAll(sort);
        return experinces.stream()
                .filter(n->n.getCv().getId()==id)
                .collect(Collectors.toList());
    }





}
