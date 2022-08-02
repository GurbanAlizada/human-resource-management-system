package com.example.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationRequest {

    @NotNull
    private int candidateId;

    @NotNull
    @NotBlank
    private String school;

    //@PastOrPresent
    private LocalDate startDate;

    //@PastOrPresent
    private LocalDate endDate;

}
