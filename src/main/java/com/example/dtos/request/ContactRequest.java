package com.example.dtos.request;

import com.example.model.Cv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToOne;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactRequest {


    private String gitHubLink;

    private String linkedInLink;




}
