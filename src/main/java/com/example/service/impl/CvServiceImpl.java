package com.example.service.impl;

import com.example.dtos.CVDto;
import com.example.repository.*;
import com.example.service.inter.CvServiceInter;
import org.springframework.stereotype.Service;


@Service
public class CvServiceImpl implements CvServiceInter {

   private final CandidateRepository candidateRepository;
   private final CoverLetterRepository coverLetterRepository;
   private final EducationRepository educationRepository;
   private final ExperienceRepository experienceRepository;
   private final LanguageRepository languageRepository;
   private final LinkRepository linkRepository;
   private final TechnologyRepository technologyRepository;
   private final PhotoRepository photoRepository;


    public CvServiceImpl(CandidateRepository candidateRepository,
                         CoverLetterRepository coverLetterRepository,
                         EducationRepository educationRepository,
                         ExperienceRepository experienceRepository,
                         LanguageRepository languageRepository,
                         LinkRepository linkRepository,
                         TechnologyRepository technologyRepository,
                         PhotoRepository photoRepository) {

        this.candidateRepository = candidateRepository;
        this.coverLetterRepository = coverLetterRepository;
        this.educationRepository = educationRepository;
        this.experienceRepository = experienceRepository;
        this.languageRepository = languageRepository;
        this.linkRepository = linkRepository;
        this.technologyRepository = technologyRepository;
        this.photoRepository =photoRepository;
    }

    @Override
    public CVDto getById(int candidateId) {
        CVDto cvDto = CVDto.builder()
                .candidate(candidateRepository.findById(candidateId).get())
                .coverLetterList(coverLetterRepository.findByCandidateId(candidateId))
                .educationList(educationRepository.findByCandidate_Id(candidateId))
                .experienceList(experienceRepository.findByCandidateId(candidateId))
                .languageList(languageRepository.findByCandidate_Id(candidateId))
                .linkList(linkRepository.findByCandidateId(candidateId))
                .technologyList(technologyRepository.findByCandidate_Id(candidateId))
                .photoList(photoRepository.findByCandidate_Id(candidateId))
                .build();

        return cvDto;

    }







}
