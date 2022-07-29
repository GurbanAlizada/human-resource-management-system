package com.example.service.impl;

import com.example.adapters.impl.CheckPerson;
import com.example.dtos.request.CandidateRequest;
import com.example.exception.MernisNotFoundExcpeption;
import com.example.model.Candidate;
import com.example.model.User;
import com.example.repository.CandidateRepository;
import com.example.service.inter.CandidateServiceInterr;
import com.example.service.inter.UserServiceInter;
import com.example.verifications.impl.FakeEmailVerificationServiceInter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CandidateServiceImpl implements CandidateServiceInterr {


    private final CandidateRepository candidateRepository;
    private final CheckPerson checkPerson;
    private final UserServiceInter userServiceInter;
    private final FakeEmailVerificationServiceInter fakeEmailVerificationServiceInter;

    public CandidateServiceImpl(CandidateRepository candidateRepository,
                                @Qualifier(value = "MernisServiceAdapter") CheckPerson checkPerson ,
                                UserServiceInter userServiceInter ,
    FakeEmailVerificationServiceInter fakeEmailVerificationServiceInter) {
        this.candidateRepository = candidateRepository;
        this.checkPerson = checkPerson;
        this.userServiceInter = userServiceInter;
        this.fakeEmailVerificationServiceInter=fakeEmailVerificationServiceInter;
    }

    private Candidate checkIdentityNumber(long identityNumber){
        return candidateRepository.getByIdentityNumber(identityNumber);
    }


    private User checkEmail(String  email){
        return userServiceInter.getByEmail(email);
    }



    @Override
    public Candidate add(CandidateRequest candidateRequest ) {

        Candidate candidate = new Candidate(
                0,
                candidateRequest.getEmail(),
                candidateRequest.getPassword(),
                candidateRequest.getName(),
                candidateRequest.getSurname(),
                candidateRequest.getIdentityNumber(),
                candidateRequest.getDateOfBirth()
        );

        if (checkPerson.checkIfRealPerson(candidate.getIdentityNumber() , candidate.getName(), candidateRequest.getSurname(), candidate.getDateOfBirth())) {

            if(checkIdentityNumber(candidate.getIdentityNumber()) == null){
                if (checkEmail(candidateRequest.getEmail()) == null){

                    if(fakeEmailVerificationServiceInter.sendEmail(null)){
                        return candidateRepository.save(candidate);
                    }else{
                        throw new MernisNotFoundExcpeption("Email dogrulamasi yapilmadi");
                    }
                }else{
                    throw new MernisNotFoundExcpeption("Bu email zaten sistemde  var");
                }
            }else{
                throw new MernisNotFoundExcpeption("Sizin zaten sistemde bir kayitiniz var");
            }
        } else {
            throw new MernisNotFoundExcpeption("Bu bilgilerde bir kisi bulunamadi");
        }
    }



    @Override
    public List<Candidate> getAll(){
        return candidateRepository.findAll();
    }













}
/*

{
  "dateOfBirth": "1985-01-06",
  "identityNumber": 28861499108,
  "name": "Engin",
  "surname": "Demiroğ"
}



{
  "dateOfBirth": "1985-01-06",
 "email": "qqqqq8q1qqq@gmail.com",
  "identityNumber": 28861499108,
  "name": "Engin",
 "password": "123455",
  "surname": "Demiroğ"
}


 */