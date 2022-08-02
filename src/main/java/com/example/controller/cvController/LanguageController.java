package com.example.controller.cvController;


import com.example.model.cv.Language;
import com.example.service.inter.LanguageServiceInter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/language")
@CrossOrigin
public class LanguageController {



    private final LanguageServiceInter languageServiceInter;

    public LanguageController(LanguageServiceInter languageServiceInter) {
        this.languageServiceInter = languageServiceInter;
    }



    @GetMapping("/getAll")
    public ResponseEntity<List<Language>> getAll(){
        return ResponseEntity.ok(languageServiceInter.getAll());
    }


    @GetMapping("/getByCandidateId")
    public ResponseEntity<List<Language>> getById(int id) {
        return ResponseEntity.ok(languageServiceInter.getById(id));
    }


}
