package com.example.service.inter;

import com.example.dtos.request.CandidateRequest;
import com.example.dtos.request.UserRequest;
import com.example.model.Candidate;
import org.ow2.easywsdl.schema.api.absItf.AbsItfAttribute;

import java.util.List;

public interface CandidateServiceInterr {

    Candidate add(CandidateRequest candidateRequest );
     List<Candidate> getAll();

}
