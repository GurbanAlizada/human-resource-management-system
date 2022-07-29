package com.example.controller;


import com.example.dtos.request.CandidateRequest;
import com.example.dtos.request.UserRequest;
import com.example.model.Candidate;
import com.example.service.impl.CandidateServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {


   private final CandidateServiceImpl candidateService;

    public CandidatesController(CandidateServiceImpl candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping("/add")
    public ResponseEntity<Candidate> add(@Valid @RequestBody  CandidateRequest candidateRequest){
        return ResponseEntity.ok(candidateService.add(candidateRequest ));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Candidate>> getAll(){
        return ResponseEntity.ok(candidateService.getAll());
    }


}
