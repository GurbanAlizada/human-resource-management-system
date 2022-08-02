package com.example.model.cv;


import com.example.model.Candidate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","candidate"})
@Table(name="images")
public class Photo implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;



    @Column(name = "url")
    private String url ;

    @Column(name = "public_id")
    private String publicId ;



    @JoinColumn(name = "candidates_id")
    @ManyToOne
    private Candidate candidate;



}
