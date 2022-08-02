package com.example.controller.cvController;


import com.example.model.cv.CoverLetter;
import com.example.service.inter.CoverLetterServiceInter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/coverLetter")
@CrossOrigin
public class CoverLetterController {


    private final CoverLetterServiceInter coverLetterServiceInter;

    public CoverLetterController(CoverLetterServiceInter coverLetterServiceInter) {
        this.coverLetterServiceInter = coverLetterServiceInter;
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<CoverLetter>> getAll(){
        return ResponseEntity.ok( coverLetterServiceInter.getAll());
    }


    @GetMapping("/getById")
    public ResponseEntity<List<CoverLetter>> getById(int id) {
        return  ResponseEntity.ok(coverLetterServiceInter.getById(id));
    }




}
