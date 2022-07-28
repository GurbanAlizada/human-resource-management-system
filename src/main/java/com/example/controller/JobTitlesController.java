package com.example.controller;


import com.example.dtos.request.JobTitleRequest;
import com.example.model.JobTitle;
import com.example.service.inter.JobTitleServiceInter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/JobTitle")
public class JobTitlesController {

    private final JobTitleServiceInter jobTitleServiceInter ;

    public JobTitlesController(JobTitleServiceInter jobTitleServiceInter) {
        this.jobTitleServiceInter = jobTitleServiceInter;
    }


    @PostMapping("/add")
    public ResponseEntity<JobTitle> add(@Valid @RequestBody JobTitleRequest jobTitleRequest){
        return ResponseEntity.ok(jobTitleServiceInter.add(jobTitleRequest));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<JobTitle>> getAll(){
        return ResponseEntity.ok(jobTitleServiceInter.getAll());
    }


    @PostMapping("/update")
    public ResponseEntity<JobTitle> update(@RequestParam("id") int id,@Valid @RequestBody JobTitleRequest jobTitleRequest){
        return ResponseEntity.ok(jobTitleServiceInter.update(id, jobTitleRequest));
    }


    @DeleteMapping("/delete")
    public ResponseEntity<JobTitle> delete(@RequestParam("id") int id){
        return ResponseEntity.ok(jobTitleServiceInter.delete(id));
    }


    @GetMapping("/getById")
    public ResponseEntity<JobTitle> getById(@RequestParam("id") int id){
        return ResponseEntity.ok(jobTitleServiceInter.getById(id));
    }



    @GetMapping("/getByTitle")
    public ResponseEntity<JobTitle> getByTitle(String title){
        return ResponseEntity.ok(jobTitleServiceInter.getByTitle(title));
    }






}
