package com.example.controller;


import com.example.dtos.request.ExperinceRequest;
import com.example.model.Education;
import com.example.model.Experince;
import com.example.service.inter.ExperinceServiceInter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/experince")
public class ExperincesController {


    private final ExperinceServiceInter experinceServiceInter;

    public ExperincesController(ExperinceServiceInter experinceServiceInter) {
        this.experinceServiceInter = experinceServiceInter;
    }



    @PostMapping("/addExperince")
    public ResponseEntity<Experince> addExperince(@Valid @RequestBody ExperinceRequest experinceRequest){
        return ResponseEntity.ok(experinceServiceInter.addExperince(experinceRequest));
    }


    @GetMapping("/getAllBySorted")
    public ResponseEntity<List<Experince>> getAllBySorted(@RequestParam("id") int id){
        return ResponseEntity.ok(experinceServiceInter.getAllBySorted(id));
    }



}
