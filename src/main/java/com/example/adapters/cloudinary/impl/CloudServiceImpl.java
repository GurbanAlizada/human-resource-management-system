package com.example.adapters.cloudinary.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.adapters.cloudinary.inter.CloudServiceInter;
import com.example.results.DataResult;
import com.example.results.ErrorDataResult;
import com.example.results.SuccessDataResult;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Service
public class CloudServiceImpl implements CloudServiceInter {


    private Cloudinary cloudinary;

    public CloudServiceImpl() {
        Map<String, String> valuesMap = new HashMap<>();
        valuesMap.put("cloud_name","alizada" );
        valuesMap.put("api_key", "231755285583346" );
        valuesMap.put("api_secret","P2WIwBBTmrFrWK3FxfBT1gkfugQ" );
        cloudinary = new Cloudinary(valuesMap);
    }

    @SneakyThrows
    @Override
    public DataResult<Map<String, String>> uploadImage(MultipartFile multipartFile) {
        File file;
        try {
            file = convert(multipartFile);
            Map<String, String> result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            file.delete();
            return new SuccessDataResult<>(result);
        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorDataResult<>("Dosya yuklenemedi");
        }

    }





    private  File convert(MultipartFile multipartFile) throws IOException {
            File file = new File(multipartFile.getOriginalFilename());
            FileOutputStream fileOutput = new FileOutputStream(file);
            fileOutput.write(multipartFile.getBytes());
            fileOutput.close();

            return file;
    }





}
