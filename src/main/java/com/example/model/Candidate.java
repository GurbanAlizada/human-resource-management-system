package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidates")
///@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cv"})
public class Candidate implements Serializable {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "identity_number")
    private long identityNumber;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth ;


    @OneToOne(cascade = { CascadeType.MERGE  , CascadeType.PERSIST} , fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;




}
