package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "verification_codes_employer")
@PrimaryKeyJoinColumn(name = "id")
public class VerificationCodeEmployer extends VerificationCode{

    @Column(name = "employer_user_id")
    private int employerUserId;



}
