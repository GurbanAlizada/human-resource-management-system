package com.example.adapters.cloudinary.inter;

import com.example.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface CloudServiceInter {


    DataResult<Map<String, String>> uploadImage(MultipartFile multipartFile);


}
