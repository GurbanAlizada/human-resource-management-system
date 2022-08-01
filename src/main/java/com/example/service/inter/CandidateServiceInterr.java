package com.example.service.inter;

import com.example.dtos.request.*;
import com.example.model.Candidate;
import com.example.model.cv.*;

import java.util.List;

public interface CandidateServiceInterr {

    Candidate add(CandidateRequest candidateRequest );
    public List<Candidate> getAll();



    public String addEducation(EducationRequest educationRequest);



    public String addLanguage(LanguageRequest languageRequest);




    public String addExperience(ExperinceRequest experinceRequest);


    public String addLink(LinkRequest linkRequest);


    public Candidate getById(int id);


    public String addTechno(TechnologyRequest technologyRequest);


    public String addLetter(CoverLetterRequest coverLetterRequest);







}
