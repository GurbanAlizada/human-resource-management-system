package com.example.model;

import com.example.model.cv.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "candidates")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler",
        "educationList",
        "coverLetterList",
        "experienceList",
        "languageList",
        "linkList",
        "technologyList"
})
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


   // @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<Education> educationList;


    @OneToMany(mappedBy = "candidate")
    private List<CoverLetter> coverLetterList;


    @OneToMany(mappedBy = "candidate")
    private List<Experience> experienceList;

    @OneToMany(mappedBy = "candidate")
    private List<Language> languageList;

    @OneToMany(mappedBy = "candidate")
    private List<Link> linkList;

    @OneToMany(mappedBy = "candidate")
    private List<Technology> technologyList;


}
