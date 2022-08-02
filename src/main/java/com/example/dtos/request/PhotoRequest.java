package com.example.dtos.request;

import com.example.model.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhotoRequest {


    private String url;
    private String publicId;
    private int candidateId;


}
