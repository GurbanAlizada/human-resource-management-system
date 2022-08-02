package com.example.model.cv;
import com.example.model.Candidate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@Builder
@EqualsAndHashCode
@Table(name = "language")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","candidate"})
public class Language implements Serializable {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    //@Min(1)
    //@Max(5)
    @Column(name="language_level")
    private int languageLevel;


    @Column(name="name")
    private String name;



   // @JsonIgnore
    @JoinColumn(name = "candidates_id")
    @ManyToOne
    private Candidate candidate;


}
