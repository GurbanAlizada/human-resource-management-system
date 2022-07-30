package com.example.dtos.request;


import com.example.model.Cv;
import com.example.model.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageRequest {



    @NotNull
    @NotBlank
    private String language;

    @NotNull
    private String languageLevel;

    @NotNull
    private int cvId;



}
