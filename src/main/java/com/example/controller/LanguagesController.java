package com.example.controller;


import com.example.dtos.request.LanguageRequest;
import com.example.model.Language;
import com.example.service.inter.LanguageServiceInter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {


    private final LanguageServiceInter languageServiceInter;

    public LanguagesController(LanguageServiceInter languageServiceInter) {
        this.languageServiceInter = languageServiceInter;
    }


    @PostMapping("/addLanguage")
    public ResponseEntity<Language> addLanguage(@RequestBody @Valid List<LanguageRequest> languageRequests){
        return ResponseEntity.ok(languageServiceInter.addLanguage(languageRequests));
    }




}
