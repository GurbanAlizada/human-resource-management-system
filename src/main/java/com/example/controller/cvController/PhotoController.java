package com.example.controller.cvController;


import com.example.adapters.cloudinary.inter.CloudServiceInter;
import com.example.dtos.request.PhotoRequest;
import com.example.model.cv.Photo;
import com.example.results.Result;
import com.example.service.impl.PhotoServiceImpl;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.LinkedHashMap;

@RestController
@RequestMapping("/api/photo")
public class PhotoController {



    private final PhotoServiceImpl photoService;
    private final CloudServiceInter cloudServiceInter;

    public PhotoController(PhotoServiceImpl photoService, CloudServiceInter cloudServiceInter) {
        this.photoService = photoService;
        this.cloudServiceInter = cloudServiceInter;
    }


    @PostMapping("/addPhoto")
    public Result addPhoto(@RequestPart MultipartFile image, int candidateId) {
        return this.photoService.addPhoto(image, candidateId);
    }






    @RequestMapping(value = "/upload1", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, method = RequestMethod.POST)
    public ResponseEntity<Void> uploadFile(@RequestPart String description, @RequestPart MultipartFile file) {
        //yaay!
        return ResponseEntity.ok(null);
    }



}








