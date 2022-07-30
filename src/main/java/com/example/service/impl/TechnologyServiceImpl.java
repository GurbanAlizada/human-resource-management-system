package com.example.service.impl;

import com.example.dtos.request.TechnologyRequest;
import com.example.model.Cv;
import com.example.model.Technology;
import com.example.repository.TechnologyRepository;
import com.example.service.inter.TechnologyServiceInter;
import org.springframework.stereotype.Service;


@Service
public class TechnologyServiceImpl implements TechnologyServiceInter {

    private final TechnologyRepository technologyRepository;
    private final CvServiceImpl cvService;


    public TechnologyServiceImpl(TechnologyRepository technologyRepository, CvServiceImpl cvService) {
        this.technologyRepository = technologyRepository;
        this.cvService = cvService;
    }

    public Technology addTechnology(TechnologyRequest technologyRequest){
        Cv cv = cvService.getById(technologyRequest.getCvId());
        Technology technology = Technology.builder()
                .usedTechnology(technologyRequest.getUsedTechnology())
                .cv(cv)
                .build();
        return technologyRepository.save(technology);
    }





}
