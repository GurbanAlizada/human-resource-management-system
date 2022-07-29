package com.example.service.inter;

import com.example.dtos.request.CandidateRequest;
import com.example.model.Candidate;

import java.util.List;

public interface CandidateServiceInterr {

    Candidate add(CandidateRequest candidateRequest );
    public List<Candidate> getAll();

}
