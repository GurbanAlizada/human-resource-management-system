package com.example.service.impl;

import com.example.dtos.AdvertisementDto;
import com.example.dtos.convert.AdvertisementDtoConvertor;
import com.example.dtos.request.AdvertisementRequest;
import com.example.exception.AdvertismentNotFoundException;
import com.example.model.Advertisment;
import com.example.model.City;
import com.example.model.Employer;
import com.example.model.JobTitle;
import com.example.repository.AdvertisementRepository;
import com.example.service.inter.AdvertisementServiceInter;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AdvertisementServiceImpl implements AdvertisementServiceInter {

    private final AdvertisementRepository advertisementRepository;
    private final AdvertisementDtoConvertor advertisementDtoConvertor;

    public AdvertisementServiceImpl(AdvertisementRepository advertisementRepository, AdvertisementDtoConvertor advertisementDtoConvertor) {
        this.advertisementRepository = advertisementRepository;
        this.advertisementDtoConvertor = advertisementDtoConvertor;
    }

    @Override
    public Advertisment add(AdvertisementRequest advertisementRequest){

        JobTitle jobTitle = JobTitle.builder()
                .id(advertisementRequest.getJobTitle())
                .build();
        City city = City.builder()
                .id(advertisementRequest.getCity())
                .build();
        Employer employer = Employer.builder()
                .id(advertisementRequest.getEmployer())
                .build();


        Advertisment advertisment = new Advertisment(
                0,
                advertisementRequest.getJobDescription(),
                advertisementRequest.getMinSalary(),
                advertisementRequest.getMaxSalary(),
                advertisementRequest.getNumberOfPosition(),
                advertisementRequest.getCreateDate(),
                advertisementRequest.getDeleteDate(),
                advertisementRequest.isEnable(),
                jobTitle,
                city,
                employer
        );

        return advertisementRepository.save(advertisment);
    }





    @Override
    public List<Advertisment> getAll(){
        return advertisementRepository.getAll();
    }

    @Override
    public List<AdvertisementDto> getByEnableTrue() {

        List<Advertisment> advertisments = advertisementRepository.getByEnableTrue();
       List<AdvertisementDto> dto =  advertisments.stream()
               .map(n->advertisementDtoConvertor.convertToAdvertisementDto(n))
               .collect(Collectors.toList());

        return dto ;
    }


    public List<AdvertisementDto> getAllBySorted(){
        Sort sort = Sort.by(Sort.Direction.DESC , "createDate");
        List<Advertisment> advertisments = advertisementRepository.findAll(sort);
        List<AdvertisementDto> dto =  advertisments.stream()
                .filter(n->n.isEnable()==true)
                .map(n->advertisementDtoConvertor.convertToAdvertisementDto(n))
                .collect(Collectors.toList());
        return dto ;
    }




    public List<AdvertisementDto> getByEmployer_CompanyName(String companyName){
        List<Advertisment> advertisments = advertisementRepository.getByEmployer_CompanyName(companyName);
        List<AdvertisementDto> dto =  advertisments.stream()
                .filter(n->n.isEnable()==true)
                .map(n->advertisementDtoConvertor.convertToAdvertisementDto(n))
                .collect(Collectors.toList());
        return dto ;
    }


    @Override
    public String deleteAdvertisement(int id){
       Advertisment advertisment= advertisementRepository.findById(id)
               .orElseThrow(
                       ()->new AdvertismentNotFoundException("Boyle bir ilan bulunmuyor"));
       advertisementRepository.delete(advertisment);
       return "Ilan basari ile silindi";
    }


    @Override
    public String toPassiv(int id){
        Advertisment advertisment= advertisementRepository.findById(id)
                .orElseThrow(
                        ()->new AdvertismentNotFoundException("Boyle bir ilan bulunmuyor"));

        advertisment.setEnable(false);
        advertisementRepository.save(advertisment);
        return "Ilan passiv oldu";
    }


    @Override
    public String toActive(int id){
        Advertisment advertisment= advertisementRepository.findById(id)
                .orElseThrow(
                        ()->new AdvertismentNotFoundException("Boylr bir ilan bulunmuyor"));

        advertisment.setEnable(true);
        advertisementRepository.save(advertisment);
        return "Ilan aktiv oldu";
    }



    @Override
    public List<AdvertisementDto> getByCity_Name(String name){
        List<Advertisment> advertisments = advertisementRepository.getByCity_Name(name);
        List<AdvertisementDto> dto =  advertisments.stream()
                .filter(n->n.isEnable()==true)
                .map(n->advertisementDtoConvertor.convertToAdvertisementDto(n))
                .collect(Collectors.toList());
        return dto ;
    }




}
