package com.example.service.impl;

import com.example.dtos.AdvertisementDto;
import com.example.dtos.request.EducationRequest;
import com.example.model.Advertisment;
import com.example.model.Cv;
import com.example.model.Education;
import com.example.repository.EducationRepository;
import com.example.service.inter.EducationServiceInter;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EducationServiceImpl implements EducationServiceInter {

    private final EducationRepository educationRepository;
    private final CvServiceImpl cvService;

    public EducationServiceImpl(EducationRepository educationRepository, CvServiceImpl cvService) {
        this.educationRepository = educationRepository;
        this.cvService = cvService;
    }

    @Override
    public Education addEducation(EducationRequest educationRequest){
        Cv cv = cvService.getById(educationRequest.getCvId());
        Education education = Education.builder()
                .schoolName(educationRequest.getSchoolName())
                .departmentName(educationRequest.getDepartmentName())
                .dateOfGraduation(educationRequest.getDateOfGraduation())
                .startingDate(educationRequest.getStartingDate())
                .cv(cv)
                .build();
        return educationRepository.save(education);
    }




    @Override
    public List<Education> getAllBySorted(int id){
        Sort sort = Sort.by(Sort.Direction.DESC , "dateOfGraduation");
        List<Education> educations = educationRepository.findAll(sort);
        return educations.stream()
                .filter(n->n.getCv().getId()==id)
                .collect(Collectors.toList());
    }




}
