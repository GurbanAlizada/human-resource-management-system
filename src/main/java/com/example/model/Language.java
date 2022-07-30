package com.example.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Language implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "language")
    private String language;

    @Column(name = "language_level")
    @Enumerated(EnumType.STRING)
    private Level languageLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id")
    private Cv cv;




}
