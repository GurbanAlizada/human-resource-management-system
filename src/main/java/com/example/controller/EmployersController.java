package com.example.controller;


import com.example.dtos.request.EmployerRequest;
import com.example.model.Employer;
import com.example.service.inter.EmployerServiceInter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController {


    private final EmployerServiceInter employerServiceInter;

    public EmployersController(EmployerServiceInter employerServiceInter) {
        this.employerServiceInter = employerServiceInter;
    }


    @PostMapping("/add")
    public ResponseEntity<Employer> add(@Valid @RequestBody EmployerRequest employerRequest){
        return ResponseEntity.ok(employerServiceInter.add(employerRequest));
    }



    @GetMapping("/getAll")
    public ResponseEntity<List<Employer>> getAll(){
        return ResponseEntity.ok(employerServiceInter.getAll());
    }



}
