package com.example.service.inter;

import com.example.model.cv.Education;
import com.example.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EducationServiceInter {


    public List<Education> getAll();
    public List<Education> findByCandidate_IdOrderByEndDateDesc(int id);



}
