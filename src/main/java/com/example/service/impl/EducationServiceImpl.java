package com.example.service.impl;

import com.example.model.cv.Education;
import com.example.repository.EducationRepository;
import com.example.service.inter.EducationServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;




@Service
public class EducationServiceImpl implements EducationServiceInter {


    private final EducationRepository educationRepository;

    public EducationServiceImpl(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }




    public List<Education> getAll(){
        return educationRepository.findAll();
    }

    public List<Education> findByCandidate_IdOrderByEndDateDesc(int id){
        return educationRepository.findByCandidate_IdOrderByEndDateDesc(id);
    }







}
