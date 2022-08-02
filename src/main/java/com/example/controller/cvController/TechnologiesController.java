package com.example.controller.cvController;


import com.example.model.cv.Technology;
import com.example.service.inter.TechnologyServiceInter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/technology")
public class TechnologiesController {



    private final TechnologyServiceInter technologyServiceInter;

    public TechnologiesController(TechnologyServiceInter technologyServiceInter) {
        this.technologyServiceInter = technologyServiceInter;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Technology>> getAll(){
        return ResponseEntity.ok(technologyServiceInter.getAll());
    }

    @GetMapping("/findByCandidate_Id")
    public ResponseEntity<List<Technology>> findByCandidate_Id(int id){
        return ResponseEntity.ok(technologyServiceInter.findByCandidate_Id(id));
    }


}
