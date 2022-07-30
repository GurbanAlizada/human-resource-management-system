package com.example.dtos.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Normalized;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvRequest {


    @NotNull
    @NotBlank
    private String coverLetter;

    @NotNull
    private int candidateId;


    @NotNull
    private int contactId;

}
