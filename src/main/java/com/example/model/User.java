package com.example.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;

//@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@JsonIgnoreProperties({
        "hibernateLazyInitializer" ,
        "handler" ,
        "candidate"
})
public class User implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String pasword;

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private Candidate candidate;

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private Employee employee;


    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private Employer employer;


    public User(String email, String pasword) {
        this.email = email;
        this.pasword = pasword;
    }
}
