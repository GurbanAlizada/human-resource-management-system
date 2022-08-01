package com.example.service.impl;

import com.example.model.cv.Experience;
import com.example.repository.ExperienceRepository;
import com.example.service.inter.ExperienceServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ExperienceServiceImpl implements ExperienceServiceInter {

    private final ExperienceRepository experienceRepository;

    public ExperienceServiceImpl(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    public List<Experience> getAll(){
        return experienceRepository.findAll();
    }


    public List<Experience> findByCandidate_IdOrderByEndDateDesc(int id){
        return experienceRepository.findByCandidate_IdOrderByEndDateDesc(id);
    }



}
