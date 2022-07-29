package com.example.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdvertisementDto {



    private String jobTitle;

    private String companyName;

    private int numberOfPosition;


    private LocalDate createDate ;

    private LocalDate deleteDate ;





}
