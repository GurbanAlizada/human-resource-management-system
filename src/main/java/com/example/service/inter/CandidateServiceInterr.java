package com.example.service.inter;

import com.example.dtos.request.*;
import com.example.model.Candidate;

import java.util.List;

public interface CandidateServiceInterr {

    Candidate add(CandidateRequest candidateRequest );

     List<Candidate> getAll();



     String addEducation(EducationRequest educationRequest);



     String addLanguage(LanguageRequest languageRequest);




     String addExperience(ExperinceRequest experinceRequest);


     String addLink(LinkRequest linkRequest);


     Candidate getById(int id);


     String addTechno(TechnologyRequest technologyRequest);


     String addLetter(CoverLetterRequest coverLetterRequest);







}
