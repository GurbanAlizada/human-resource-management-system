package com.example.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Technology implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "used_technology")
    private String usedTechnology;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id")
    private Cv cv;






}
