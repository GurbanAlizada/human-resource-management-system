package com.example.adapters.inter;

import com.example.adapters.impl.CheckPerson;
import com.example.mernisService.CNGKPSPublicSoap;
import com.example.model.Candidate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service(value = "MernisServiceAdapter")
public class MernisServiceAdapter implements CheckPerson {


    @Override
    public boolean checkIfRealPerson(long identityNumber , String name , String surname , LocalDate dateOfBirth) {
        CNGKPSPublicSoap kpsPublicSoap = new CNGKPSPublicSoap();
        try {

            // Long.valueOf(candidate.getIdentityNumber())
            // candidate.getDateOfBirth().getYear()
            //return kpsPublicSoap.TCKimlikNoDogrula(28861499108L, "Engin", "Demiroğ",1985);

            //"Engin" , "Demiroğ" , LocalDate.of(1985 , 1 , 6) ,28861499108L
            return kpsPublicSoap.TCKimlikNoDogrula(identityNumber, name, surname,dateOfBirth.getYear());

            //  return kpsPublicSoap.TCKimlikNoDogrula(Long.valueOf(candidate.getIdentityNumber()), candidate.getName(), candidate.getSurname(),candidate.getDateOfBirth().getYear());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }




}
