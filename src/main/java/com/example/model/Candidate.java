package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidates")
@PrimaryKeyJoinColumn(name = "user_id")
public class Candidate extends User {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "identity_number")
    private long identityNumber;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth ;

    public Candidate(int id, String email, String pasword, String name,
                     String surname, long identityNumber, LocalDate dateOfBirth) {
        super(id, email, pasword);
        this.name = name;
        this.surname = surname;
        this.identityNumber = identityNumber;
        this.dateOfBirth = dateOfBirth;
    }

}
