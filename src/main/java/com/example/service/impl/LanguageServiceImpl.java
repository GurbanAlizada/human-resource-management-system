package com.example.service.impl;

import com.example.dtos.request.LanguageRequest;
import com.example.model.Cv;
import com.example.model.Language;
import com.example.model.Level;
import com.example.repository.LanguageRepository;
import com.example.service.inter.LanguageServiceInter;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LanguageServiceImpl implements LanguageServiceInter {

    private final LanguageRepository languageRepository;
    private final CvServiceImpl cvService;


    public LanguageServiceImpl(LanguageRepository languageRepository, CvServiceImpl cvService) {
        this.languageRepository = languageRepository;
        this.cvService = cvService;
    }

    @Override
    public Language addLanguage(List<LanguageRequest> languageRequests){
        for(LanguageRequest languageRequest : languageRequests) {
            Cv cv = cvService.getById(languageRequest.getCvId());
            Level level = Level.valueOf(languageRequest.getLanguageLevel());
            Language language = Language.builder()
                    .language(languageRequest.getLanguage())
                    .languageLevel(level)
                    .cv(cv)
                    .build();
            return languageRepository.save(language);
        }
        return null;
    }







}
