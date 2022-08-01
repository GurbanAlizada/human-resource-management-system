package com.example.service.impl;

import com.example.model.cv.CoverLetter;
import com.example.repository.CoverLetterRepository;
import com.example.service.inter.CoverLetterServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CoverLetterService implements CoverLetterServiceInter {



    private final CoverLetterRepository coverLetterRepository;

    public CoverLetterService(CoverLetterRepository coverLetterRepository) {
        this.coverLetterRepository = coverLetterRepository;
    }

    public List<CoverLetter> getAll(){
        return coverLetterRepository.findAll();
    }




}
