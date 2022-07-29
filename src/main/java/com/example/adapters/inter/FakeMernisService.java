package com.example.adapters.inter;

import com.example.adapters.impl.CheckPerson;
import com.example.model.Candidate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service(value = "FakeMernisService")
public class FakeMernisService implements CheckPerson {



    @Override
    public boolean checkIfRealPerson(long identityNumber , String name , String surname , LocalDate dateOfBirth) {
        return true;
    }



}
