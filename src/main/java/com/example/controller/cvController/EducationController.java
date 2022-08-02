package com.example.controller.cvController;


import com.example.model.cv.Education;
import com.example.service.impl.EducationServiceImpl;
import com.example.service.inter.EducationServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzTransactionManager;
import org.springframework.data.annotation.AccessType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/education")
public class EducationController {

    private final EducationServiceInter educationService;

    public EducationController(EducationServiceInter educationService) {
        this.educationService = educationService;
    }


    @GetMapping("/sorted")
    public ResponseEntity<List<Education>> findByCandidate_IdOrderByEndDateDesc(int id){
        return ResponseEntity.ok(educationService.findByCandidate_IdOrderByEndDateDesc(id));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Education>> getAll(){
        return ResponseEntity.ok(educationService.getAll());
    }



}
