package com.example.adapters.impl;

import com.example.model.Candidate;

import java.time.LocalDate;

public interface CheckPerson {
    boolean checkIfRealPerson(long identityNumber , String name , String surname , LocalDate dateOfBirth);
}
