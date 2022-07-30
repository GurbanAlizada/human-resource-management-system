package com.example.controller;


import com.example.dtos.request.EducationRequest;
import com.example.model.Education;
import com.example.service.inter.EducationServiceInter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/educations")
public class EducationsController {

    private final EducationServiceInter educationServiceInter;

    public EducationsController(EducationServiceInter educationServiceInter) {
        this.educationServiceInter = educationServiceInter;
    }


    @PostMapping("/addEducation")
    public ResponseEntity<Education> addEducation(@Valid @RequestBody EducationRequest educationRequest){
        return ResponseEntity.ok(educationServiceInter.addEducation(educationRequest));
    }


    @GetMapping("/getAllBySorted")
    public ResponseEntity<List<Education>> getAllBySorted(@RequestParam("id") int id){
        return ResponseEntity.ok(educationServiceInter.getAllBySorted(id));
    }





}
