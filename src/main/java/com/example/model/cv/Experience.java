package com.example.model.cv;

import com.example.model.Candidate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","candidate"})
public class Experience {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotNull
    @NotBlank
    @Column(name="company_name")
    private String companyName;

 //   @PastOrPresent
    @NotNull
    @Column(name="start_date")
    private LocalDate startDate;

 //   @PastOrPresent
    @Column(name="end_date")
    private LocalDate endDate;

    @JsonIgnore
    @JoinColumn(name="candidates_id")
    @ManyToOne
    private Candidate candidate;







}
