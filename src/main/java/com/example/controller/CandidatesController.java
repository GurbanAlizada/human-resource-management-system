package com.example.controller;


import com.example.dtos.request.*;
import com.example.model.Candidate;
import com.example.model.cv.*;
import com.example.service.impl.CandidateServiceImpl;
import com.example.service.inter.CandidateServiceInterr;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidatesController {


   private final CandidateServiceInterr candidateService;

    public CandidatesController(CandidateServiceImpl candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping("/add")
    public ResponseEntity<Candidate> add(@Valid @RequestBody  CandidateRequest candidateRequest ){
        return ResponseEntity.ok(candidateService.add(candidateRequest ));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Candidate>> getAll(){
        return ResponseEntity.ok(candidateService.getAll());
    }


    @GetMapping("/getById")
    public ResponseEntity<Candidate> getById(@RequestParam("id") int id){
        return ResponseEntity.ok(candidateService.getById(id));
    }



}
