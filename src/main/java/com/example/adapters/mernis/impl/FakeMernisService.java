package com.example.adapters.mernis.impl;

import com.example.adapters.mernis.inter.CheckPerson;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service(value = "FakeMernisService")
public class FakeMernisService implements CheckPerson {



    @Override
    public boolean checkIfRealPerson(
            long identityNumber ,
            String name ,
            String surname ,
            LocalDate dateOfBirth
    ) {

        return true;
    }



}
