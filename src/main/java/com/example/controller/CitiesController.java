package com.example.controller;


import com.example.dtos.request.CityRequest;
import com.example.model.City;
import com.example.repository.CityRepository;
import com.example.service.inter.CityServiceInter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CitiesController {



    private final CityServiceInter serviceInter;

    public CitiesController(CityServiceInter serviceInter) {
        this.serviceInter = serviceInter;
    }



    @PostMapping("/add")
    public ResponseEntity<City> add(@Valid @RequestBody CityRequest cityRequest){
        return  ResponseEntity.ok(serviceInter.add(cityRequest));

    }



    @GetMapping("/getAll")
    public ResponseEntity<List<City>> getAll(){
        return ResponseEntity.ok(serviceInter.getAll());
    }




}
