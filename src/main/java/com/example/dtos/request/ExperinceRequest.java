package com.example.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExperinceRequest {


    private String companyName;
    private LocalDate startDate;
    private LocalDate endDate;
    private int candidateId;


}
