package com.example.dtos.request;

import com.example.model.Cv;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationRequest {

    @NotNull
    @NotBlank
    private String schoolName;

    @NotNull
    @NotBlank
    private String departmentName;

    @NotNull
    private LocalDate startingDate;

    private  LocalDate dateOfGraduation;

    @NotNull
    private int cvId;

}
