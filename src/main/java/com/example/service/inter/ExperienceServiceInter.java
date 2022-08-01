package com.example.service.inter;

import com.example.model.cv.Experience;
import com.example.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ExperienceServiceInter {

     List<Experience> getAll();
     List<Experience> findByCandidate_IdOrderByEndDateDesc(int id);

}
