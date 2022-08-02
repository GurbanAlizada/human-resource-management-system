package com.example.model.cv;

import com.example.model.Candidate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "education")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","candidate"})
public class Education implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    //@NotNull
    //@NotBlank
    @Column(name="company_name")
    private String school;



   // @PastOrPresent
    //@NotNull
    @Column(name="start_date")
    private LocalDate startDate;



   // @PastOrPresent
    @Column(name="end_date")
    private LocalDate endDate;



   // @JsonIgnore
    @JoinColumn(name="candidates_id")
    @ManyToOne
    private Candidate candidate;



}
