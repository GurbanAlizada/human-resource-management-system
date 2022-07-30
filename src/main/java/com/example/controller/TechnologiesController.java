package com.example.controller;


import com.example.dtos.request.TechnologyRequest;
import com.example.model.Technology;
import com.example.service.inter.TechnologyServiceInter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/technology")
public class TechnologiesController {


    private final TechnologyServiceInter technologyServiceInter;

    public TechnologiesController(TechnologyServiceInter technologyServiceInter) {
        this.technologyServiceInter = technologyServiceInter;
    }


    @PostMapping("/addTechnology")
    public ResponseEntity<Technology> addTechnology(@Valid @RequestBody TechnologyRequest technologyRequest){
        return ResponseEntity.ok(technologyServiceInter.addTechnology(technologyRequest));
    }




}
