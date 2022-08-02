package com.example.dtos;

import com.example.model.Candidate;
import com.example.model.cv.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CVDto {


    Candidate candidate;

    List<Experience> experienceList;

    List<Language> languageList;

    List<Link> linkList;

    List<Education> educationList;

    List<Technology> technologyList;

    List<CoverLetter> coverLetterList;





}
