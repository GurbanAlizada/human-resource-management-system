package com.example.controller.cvController;


import com.example.dtos.CVDto;
import com.example.dtos.request.*;
import com.example.service.inter.CandidateServiceInterr;
import com.example.service.inter.CvServiceInter;
import org.springframework.boot.autoconfigure.quartz.QuartzTransactionManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cv")
public class CvController {

    private final CvServiceInter cvServiceInter;
    private final CandidateServiceInterr candidateService;

    public CvController(CvServiceInter cvServiceInter, CandidateServiceInterr candidateService) {
        this.cvServiceInter = cvServiceInter;
        this.candidateService = candidateService;
    }

    @GetMapping("/getById")
    public CVDto getById(@RequestParam("id") int id){
        return  cvServiceInter.getById(id);
    }





    @PostMapping("/addEducation")
    public String addEducation(@RequestBody EducationRequest educationRequest){
        return candidateService.addEducation(educationRequest);
    }



    @PostMapping("/addLanguage")
    public String addLanguage(@RequestBody LanguageRequest languageRequest){
        return candidateService.addLanguage(languageRequest);
    }



    @PostMapping("/addExperience")
    public String addExperience(@RequestBody ExperinceRequest experinceRequest){
        return candidateService.addExperience(experinceRequest);
    }



    @PostMapping("/addLink")
    public String addLink(@RequestBody LinkRequest linkRequest){

        return candidateService.addLink(linkRequest);
    }




    @PostMapping("/addTechno")
    public String addTechno(@RequestBody TechnologyRequest technologyRequest){

        return candidateService.addTechno(technologyRequest);
    }


    @PostMapping("/addLetter")
    public String addLetter(@RequestBody CoverLetterRequest coverLetterRequest){
        return candidateService.addLetter(coverLetterRequest);
    }



}
