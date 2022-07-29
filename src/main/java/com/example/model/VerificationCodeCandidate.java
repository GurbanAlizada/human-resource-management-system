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
@Table(name = "verification_codes_candidates")
@PrimaryKeyJoinColumn(name = "id")
public class VerificationCodeCandidate extends VerificationCode{

    @Column(name = "candidate_user_id")
    private int candidateUserId;


}
