package com.example.adapters.mernis.impl;

import com.example.adapters.mernis.inter.CheckPerson;
import com.example.mernisService.CNGKPSPublicSoap;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service(value = "MernisServiceAdapter")
public class MernisServiceAdapter implements CheckPerson {


    @Override
    public boolean checkIfRealPerson(long identityNumber ,
                                     String name ,
                                     String surname ,
                                     LocalDate dateOfBirth) {

        CNGKPSPublicSoap kpsPublicSoap = new CNGKPSPublicSoap();
        try {
            return kpsPublicSoap.TCKimlikNoDogrula(identityNumber, name, surname,dateOfBirth.getYear());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }




}
