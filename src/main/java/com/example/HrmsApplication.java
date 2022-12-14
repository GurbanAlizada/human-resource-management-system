package com.example;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import com.cloudinary.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@EnableSwagger2
@SpringBootApplication
public class HrmsApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(HrmsApplication.class, args);
/*
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "alizada",
                "api_key", "231755285583346",
                "api_secret", "P2WIwBBTmrFrWK3FxfBT1gkfugQ",
                "secure", true));


        File file = new File("deneme.png");
        Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());

        System.out.println(uploadResult.get("url"));
*/
    }


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example"))
                .build();
    }






}
