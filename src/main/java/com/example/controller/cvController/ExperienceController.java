package com.example.controller.cvController;

import com.example.model.cv.Experience;
import com.example.service.impl.ExperienceServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/experice")
@CrossOrigin
public class ExperienceController {

    private final ExperienceServiceImpl  experienceService;


    public ExperienceController(ExperienceServiceImpl experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Experience>> getAll(){
        return ResponseEntity.ok(experienceService.getAll());
    }


    @GetMapping("/getAllBySorted")
    public ResponseEntity<List<Experience>>
    findByCandidate_IdOrderByEndDateDesc(int id){
        return ResponseEntity.ok(
                experienceService.findByCandidate_IdOrderByEndDateDesc(id)
        );
    }
}
