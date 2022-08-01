package com.example.controller.cvController;


import com.example.service.inter.CoverLetterServiceInter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/coverLetter")
public class CoverLetterController {


    private final CoverLetterServiceInter coverLetterServiceInter;

    public CoverLetterController(CoverLetterServiceInter coverLetterServiceInter) {
        this.coverLetterServiceInter = coverLetterServiceInter;
    }


    @GetMapping("/getAll")
    public List<com.example.model.cv.CoverLetter> getAll(){
        return coverLetterServiceInter.getAll();
    }






}
