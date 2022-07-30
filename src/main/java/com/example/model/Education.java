package com.example.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@NoArgsConstructor
public class Education implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "starting_date")
    private LocalDate startingDate;

    @Column(name = "date_of_education")
    private  LocalDate dateOfGraduation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id")
    private Cv cv;


}
