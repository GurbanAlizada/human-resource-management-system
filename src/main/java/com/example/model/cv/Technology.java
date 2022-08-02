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
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "technology")
@Builder
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","candidate"})
public class Technology implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @Column(name="used_technology")
    private String usedTechnology;



    //@JsonIgnore
    @JoinColumn(name = "candidates_id")
    @ManyToOne
    private Candidate candidate;


}
