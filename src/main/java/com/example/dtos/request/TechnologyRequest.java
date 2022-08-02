package com.example.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyRequest {

    @NotBlank
    @NotNull
    private String usedTechnology;

    @NotNull
    private int candidateId;

}
