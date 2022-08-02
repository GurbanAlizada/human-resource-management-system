package com.example.dtos.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoverLetterRequest {


    @NotNull
    @NotBlank
    private String cover;

    @NotNull
    private int candidateId;



}
