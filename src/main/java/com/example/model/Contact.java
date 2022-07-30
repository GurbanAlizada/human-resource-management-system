package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String gitHubLink;

    private String linkedInLink;


    @OneToOne(mappedBy = "contact")
    @JsonIgnore
    private Cv cv;



}
