package com.example.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "cvs")
public class Cv implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "cover_letter")
    private String coverLetter;


    @OneToMany(mappedBy = "cv")
    @JsonIgnore
    private List<Experince> experinces = new ArrayList<>();


    @OneToMany(mappedBy = "cv")
    @JsonIgnore
    private List<Education> educations = new ArrayList<>();


    @OneToMany(mappedBy = "cv")
    @JsonIgnore
    private List<Language> languages = new ArrayList<>();


    @OneToMany(mappedBy = "cv")
    @JsonIgnore
    private List<Technology> technologies = new ArrayList<>();


    @OneToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;



    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;





}
