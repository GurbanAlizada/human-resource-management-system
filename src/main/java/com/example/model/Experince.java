package com.example.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "experinces")
@Entity
public class Experince implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "school_name")
    private String companyName;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "starting_date")
    private LocalDate startingDate;

    @Column(name = "date_of_finished")
    private  LocalDate dateOfGraduation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id")
    private Cv cv;



}
