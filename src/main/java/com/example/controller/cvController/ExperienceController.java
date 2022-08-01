package com.example.controller.cvController;

import com.example.model.cv.Experience;
import com.example.service.impl.ExperienceServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/experice")
public class ExperienceController {

    private final ExperienceServiceImpl  experienceService;


    public ExperienceController(ExperienceServiceImpl experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping("/getAll")
    public List<Experience> getAll(){
        return experienceService.getAll();
    }


    @GetMapping("/getAllBySorted")
    public List<Experience> findByCandidate_IdOrderByEndDateDesc(int id){
        return experienceService.findByCandidate_IdOrderByEndDateDesc(id);
    }
}
