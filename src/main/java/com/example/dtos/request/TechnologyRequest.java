package com.example.dtos.request;

import com.example.model.Cv;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyRequest {



        @NotNull
        @NotBlank
        private String usedTechnology;


        @NotNull
        private int cvId;



}
