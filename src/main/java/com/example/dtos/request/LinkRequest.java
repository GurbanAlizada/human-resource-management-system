package com.example.dtos.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkRequest {

    private String githubLink;


    private String linkedinLink;

    private int candidateId;


}
