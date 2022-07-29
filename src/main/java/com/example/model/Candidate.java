package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidates")
//@PrimaryKeyJoinColumn(name = "user_id")
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


    @OneToOne(cascade = { CascadeType.MERGE  , CascadeType.PERSIST} )
    @JoinColumn(name = "user_id")
    private User user;



}
