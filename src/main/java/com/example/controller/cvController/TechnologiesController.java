package com.example.controller.cvController;


import com.example.model.cv.Technology;
import com.example.service.inter.TechnologyServiceInter;
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
    public List<Technology> getAll(){
        return technologyServiceInter.getAll();
    }




}
