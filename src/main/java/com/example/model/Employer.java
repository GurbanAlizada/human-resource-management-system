package com.example.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employers")
@EqualsAndHashCode
@Builder
//@PrimaryKeyJoinColumn(name = "user_id")
public class Employer implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "web_address")
    private String webAddress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne(cascade = {CascadeType.MERGE , CascadeType.PERSIST})
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "employer")
    @JsonIgnore
    private List<Advertisment> advertismens;


}
