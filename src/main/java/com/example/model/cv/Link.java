package com.example.model.cv;
import com.example.model.Candidate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","candidate"})
public class Link implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @Column(name="github_link")
    private String githubLink;


    @Column(name="linkedin_link")
    private String linkedinLink;



   // @JsonIgnore
    @JoinColumn(name = "candidates_id")
    @ManyToOne
    private Candidate candidate;






}
