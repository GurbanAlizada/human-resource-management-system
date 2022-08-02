package com.example.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExperinceRequest {


    @NotNull
    @NotBlank
    private String companyName;

    //@PastOrPresent
    private LocalDate startDate;

    //@PastOrPresent
    private LocalDate endDate;

    @NotNull
    @Positive
    private int candidateId;


}
