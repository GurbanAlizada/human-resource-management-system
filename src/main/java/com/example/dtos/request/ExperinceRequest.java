package com.example.dtos.request;

import com.example.model.Cv;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExperinceRequest {



    @NotNull
    @NotBlank
    private String companyName;

    @NotNull
    @NotBlank
    private String departmentName;

    @NotNull
    private LocalDate startingDate;

    private  LocalDate dateOfGraduation;

    @NotNull
    private int cvId;





}
