package com.example.dtos.request;


import com.example.model.City;
import com.example.model.Employer;
import com.example.model.JobTitle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdvertisementRequest {



    @NotNull
    @NotBlank
    private String jobDescription;

    @NotNull
    private int minSalary;

    @NotNull
    private int maxSalary;

    @NotNull
    private int numberOfPosition;


    private LocalDate createDate ;


    private LocalDate deleteDate ;

    @NotNull
    private boolean enable ;

    @NotNull
    private int jobTitle;

    @NotNull
    private int city;

    @NotNull
    private int employer;





}
