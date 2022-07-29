package com.example.controller;


import com.example.dtos.AdvertisementDto;
import com.example.dtos.request.AdvertisementRequest;
import com.example.model.Advertisment;
import com.example.service.inter.AdvertisementServiceInter;
import org.apache.catalina.LifecycleState;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/advertisents")
public class AdvertisementsController {

    private final AdvertisementServiceInter advertisementServiceInter;

    public AdvertisementsController(AdvertisementServiceInter advertisementServiceInter) {
        this.advertisementServiceInter = advertisementServiceInter;
    }


    @PostMapping("/add")
    public ResponseEntity<Advertisment> add(@Valid @RequestBody AdvertisementRequest advertisementRequest){
        return ResponseEntity.ok(advertisementServiceInter.add(advertisementRequest));
    }




    @GetMapping("/getAll")
    public ResponseEntity<List<Advertisment>> getAll(){
        return ResponseEntity.ok(advertisementServiceInter.getAll());
    }


    @GetMapping("/getByEnableTrue")
    public ResponseEntity<List<AdvertisementDto>> getByEnableTrue(){
        return ResponseEntity.ok(advertisementServiceInter.getByEnableTrue());
    }


    @GetMapping("/getAllBySorted")
    public List<AdvertisementDto> getAllBySorted(){
        return advertisementServiceInter.getAllBySorted();
    }



    @GetMapping("/getByCompanyName")
    public List<AdvertisementDto> getByEmployer_CompanyName(String companyName){
        return advertisementServiceInter.getByEmployer_CompanyName(companyName);
    }


    @GetMapping("/deleteAdvertisement")
    public String deleteAdvertisement(int id){
        return advertisementServiceInter.deleteAdvertisement(id);
    }

    @GetMapping("/toPassiv")
    public String toPassiv(int id){
        return advertisementServiceInter.toPassiv(id);
    }


    @GetMapping("/toActive")
    public String toActive(int id) {
        return advertisementServiceInter.toActive(id);
    }

}
