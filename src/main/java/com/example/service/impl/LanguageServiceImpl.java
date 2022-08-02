package com.example.service.impl;

import com.example.model.cv.Language;
import com.example.repository.LanguageRepository;
import com.example.service.inter.LanguageServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LanguageServiceImpl implements LanguageServiceInter {


    private final LanguageRepository languageRepository;

    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<Language> getAll(){
        return languageRepository.findAll();
    }

    @Override
    public List<Language> getById(int id) {
        return languageRepository.findByCandidate_Id(id);
    }


}
