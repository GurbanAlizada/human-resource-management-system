package com.example.controller;


import com.example.dtos.request.EmployerRequest;
import com.example.model.Employer;
import com.example.service.inter.EmployerServiceInter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {


    private final EmployerServiceInter employerServiceInter;

    public EmployersController(EmployerServiceInter employerServiceInter) {
        this.employerServiceInter = employerServiceInter;
    }


    @PostMapping("/add")
    public ResponseEntity<Employer> add(@Valid @RequestBody EmployerRequest employerRequest){
        return ResponseEntity.ok(employerServiceInter.add(employerRequest));
    }






}
