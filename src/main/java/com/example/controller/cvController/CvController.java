package com.example.controller.cvController;


import com.example.dtos.CVDto;
import com.example.dtos.request.*;
import com.example.service.inter.CandidateServiceInterr;
import com.example.service.inter.CvServiceInter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/cv")
@CrossOrigin
public class CvController {

    private final CvServiceInter cvServiceInter;
    private final CandidateServiceInterr candidateService;

    public CvController(CvServiceInter cvServiceInter, CandidateServiceInterr candidateService) {
        this.cvServiceInter = cvServiceInter;
        this.candidateService = candidateService;
    }




    @GetMapping("/getById")
    public ResponseEntity<CVDto> getById(@RequestParam("id") int id){
        return  ResponseEntity.ok(cvServiceInter.getById(id));
    }





    @PostMapping("/addEducation")
    public ResponseEntity<String> addEducation(@RequestBody @Valid EducationRequest educationRequest){
        return ResponseEntity.ok(candidateService.addEducation(educationRequest));
    }



    @PostMapping("/addLanguage")
    public ResponseEntity<String> addLanguage(@Valid @RequestBody LanguageRequest languageRequest){
        return ResponseEntity.ok(candidateService.addLanguage(languageRequest));
    }



    @PostMapping("/addExperience")
    public ResponseEntity<String> addExperience(@RequestBody @Valid ExperinceRequest experinceRequest){
        return ResponseEntity.ok(candidateService.addExperience(experinceRequest));
    }



    @PostMapping("/addLink")
    public ResponseEntity<String> addLink(@RequestBody @Valid LinkRequest linkRequest){

        return ResponseEntity.ok(candidateService.addLink(linkRequest));
    }




    @PostMapping("/addTechno")
    public ResponseEntity<String> addTechno(@RequestBody @Valid TechnologyRequest technologyRequest){

        return ResponseEntity.ok(candidateService.addTechno(technologyRequest));
    }


    @PostMapping("/addLetter")
    public ResponseEntity<String> addLetter(@RequestBody @Valid CoverLetterRequest coverLetterRequest){
        return ResponseEntity.ok(candidateService.addLetter(coverLetterRequest));
    }






}
