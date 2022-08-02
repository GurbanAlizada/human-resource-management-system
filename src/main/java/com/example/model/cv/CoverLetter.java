package com.example.model.cv;

import com.example.model.Candidate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Builder
@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "cover_letter")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","candidate"})
public class CoverLetter implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @Column(name="cover")
    private String cover;


   // @JsonIgnore
    @JoinColumn(name = "candidates_id")
    @ManyToOne
    private Candidate candidate;








}
