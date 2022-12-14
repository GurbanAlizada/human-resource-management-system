package com.example.service.impl;

import com.example.model.cv.Technology;
import com.example.repository.TechnologyRepository;
import com.example.service.inter.TechnologyServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TechnologyServiceImpl implements TechnologyServiceInter {

   private final TechnologyRepository technologyRepository;

    public TechnologyServiceImpl(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }




    @Override
    public List<Technology> getAll(){
        return technologyRepository.findAll();
    }


    @Override
   public List<Technology> findByCandidate_Id(int id){
        return technologyRepository.findByCandidate_Id(id);
    }


}
