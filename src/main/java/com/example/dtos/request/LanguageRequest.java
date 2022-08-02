package com.example.dtos.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageRequest {

    @NotNull(message = "Lutfen bu alani doldurun")
    @Min(1)
    @Max(5)
    private int languageLevel;

    @NotBlank
    @NotNull
    private String name;

    @NotNull
    private int candidateId;

}
