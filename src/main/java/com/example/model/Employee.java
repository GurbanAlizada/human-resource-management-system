package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
//@PrimaryKeyJoinColumn(name = "user_id")
public class Employee implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="name")
    private String name;

    @Column(name = "surname")
    private String surname;


    @OneToOne(cascade = {CascadeType.MERGE , CascadeType.PERSIST})
    @JoinColumn(name = "user_id")
    private User user;




}
