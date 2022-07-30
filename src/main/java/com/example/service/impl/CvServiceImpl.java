package com.example.service.impl;

import com.example.dtos.request.CvRequest;
import com.example.exception.CvNotFoundException;
import com.example.model.Candidate;
import com.example.model.Contact;
import com.example.model.Cv;
import com.example.repository.CandidateRepository;
import com.example.repository.CvRepository;
import com.example.service.inter.CandidateServiceInterr;
import com.example.service.inter.CvServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CvServiceImpl implements CvServiceInter {


    private final CvRepository cvRepository;

    private final CandidateServiceImpl candidateService;

    private final ContactServiceImpl contactService;

    public CvServiceImpl(CvRepository cvRepository,
                         CandidateServiceImpl candidateService,
                         ContactServiceImpl contactService) {

        this.cvRepository = cvRepository;
        this.candidateService = candidateService;
        this.contactService = contactService;
    }

    protected Cv getById(int id){
        return cvRepository.findById(id)
                .orElseThrow(
                        ()->new CvNotFoundException("Boyle bir cv bulunmuyor"));
    }



    public Cv addCv(CvRequest cvRequest){

        Candidate candidate = candidateService.getById(cvRequest.getCandidateId());
        Contact contact =  contactService.getById(cvRequest.getContactId());

        Cv cv = Cv.builder()
                .coverLetter(cvRequest.getCoverLetter())
                .candidate(candidate)
                .contact(contact)
                .build();
        return cvRepository.save(cv);

    }


    @Override
    public List<Cv> getAll(){
        return cvRepository.findAll();
    }





}
