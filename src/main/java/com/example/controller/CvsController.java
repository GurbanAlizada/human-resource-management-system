package com.example.controller;


import com.example.dtos.request.CvRequest;
import com.example.model.Cv;
import com.example.service.inter.CvServiceInter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cvs")
public class CvsController {


    private final CvServiceInter cvServiceInter;

    public CvsController(CvServiceInter cvServiceInter) {
        this.cvServiceInter = cvServiceInter;
    }


    @PostMapping("/addCv")
    public ResponseEntity<Cv> addCv(@Valid @RequestBody CvRequest cvRequest){
        return ResponseEntity.ok(cvServiceInter.addCv(cvRequest));
    }


    @GetMapping("/getAll")
    public List<Cv> getAll(){
        return cvServiceInter.getAll();
    }



}
