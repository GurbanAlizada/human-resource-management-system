package com.example.service.impl;

import com.example.dtos.CVDto;
import com.example.repository.*;
import com.example.service.inter.CvServiceInter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvServiceImpl implements CvServiceInter {

   private final CandidateRepository candidateRepository;
   private final CoverLetterRepository coverLetterRepository;
   private final EducationRepository educationRepository;
   private final ExperienceRepository experienceRepository;
   private final LanguageRepository languageRepository;
   private final LinkRepository linkRepository;
   private final TechnologyRepository technologyRepository;


    public CvServiceImpl(CandidateRepository candidateRepository,
                         CoverLetterRepository coverLetterRepository,
                         EducationRepository educationRepository,
                         ExperienceRepository experienceRepository,
                         LanguageRepository languageRepository,
                         LinkRepository linkRepository,
                         TechnologyRepository technologyRepository) {

        this.candidateRepository = candidateRepository;
        this.coverLetterRepository = coverLetterRepository;
        this.educationRepository = educationRepository;
        this.experienceRepository = experienceRepository;
        this.languageRepository = languageRepository;
        this.linkRepository = linkRepository;
        this.technologyRepository = technologyRepository;
    }

    @Override
    public CVDto getById(int candidateId) {
        CVDto cvDto = CVDto.builder()
                .candidate(candidateRepository.findById(candidateId).get())
                .coverLetterList(coverLetterRepository.findByCandidateId(candidateId))
                .educationList(educationRepository.findByCandidateId(candidateId))
                .experienceList(experienceRepository.findByCandidateId(candidateId))
                .languageList(languageRepository.findByCandidateId(candidateId))
                .linkList(linkRepository.findByCandidateId(candidateId))
                .technologyList(technologyRepository.findByCandidateId(candidateId))
                .build();

        return cvDto;

    }







}