package com.example.dtos.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkRequest {

    @NotNull
    @NotBlank
    private String githubLink;


    @NotNull
    @NotBlank
    private String linkedinLink;

    @NotNull
    @Positive
    private int candidateId;


}
