package com.example.controller.cvController;


import com.example.model.cv.Language;
import com.example.service.inter.LanguageServiceInter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/language")
public class LanguageController {



    private final LanguageServiceInter languageServiceInter;

    public LanguageController(LanguageServiceInter languageServiceInter) {
        this.languageServiceInter = languageServiceInter;
    }



    @GetMapping("/getAll")
    public List<Language> getAll(){
        return languageServiceInter.getAll();
    }



}
