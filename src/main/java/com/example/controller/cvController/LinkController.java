package com.example.controller.cvController;


import com.example.model.cv.Link;
import com.example.service.inter.LinkServiceInter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/link")
public class LinkController {


    private final LinkServiceInter linkServiceInter;

    public LinkController(LinkServiceInter linkServiceInter) {
        this.linkServiceInter = linkServiceInter;
    }



    @GetMapping("/getAll")
    public List<Link> getAll(){
        return linkServiceInter.getAll();
    }








}
