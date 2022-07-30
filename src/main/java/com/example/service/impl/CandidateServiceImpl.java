package com.example.service.impl;

import com.example.adapters.impl.CheckPerson;
import com.example.dtos.request.CandidateRequest;
import com.example.exception.CandidateNotFoundException;
import com.example.exception.MernisNotFoundExcpeption;
import com.example.model.Candidate;
import com.example.model.User;
import com.example.repository.CandidateRepository;
import com.example.service.inter.CandidateServiceInterr;
import com.example.service.inter.UserServiceInter;
import com.example.verifications.inter.FakeEmailVerificationServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CandidateServiceImpl implements CandidateServiceInterr {


    private final CandidateRepository candidateRepository;
    private final CheckPerson checkPerson;
    private final UserServiceInter userServiceInter;
    private final FakeEmailVerificationServiceImpl fakeEmailVerificationService;

    public CandidateServiceImpl(CandidateRepository candidateRepository,
                                @Qualifier(value = "MernisServiceAdapter") CheckPerson checkPerson ,
                                UserServiceInter userServiceInter ,
                                FakeEmailVerificationServiceImpl fakeEmailVerificationService
                              ) {

        this.candidateRepository = candidateRepository;
        this.checkPerson = checkPerson;
        this.userServiceInter = userServiceInter;
        this.fakeEmailVerificationService=fakeEmailVerificationService;
    }

    private Candidate checkIdentityNumber(long identityNumber){
        return candidateRepository.getByIdentityNumber(identityNumber);
    }


    private User checkEmail(String  email){
        return userServiceInter.getByEmail(email);
    }


    protected Candidate getById(int id){
        return candidateRepository.findById(id)
                .orElseThrow(
                        ()->new CandidateNotFoundException("Boyle bir is ariyan bulunmadi"));
    }


    @Override
    public Candidate add(CandidateRequest candidateRequest ) {

        if (checkPerson.checkIfRealPerson(candidateRequest.getIdentityNumber() , candidateRequest.getName(), candidateRequest.getSurname(), candidateRequest.getDateOfBirth())) {
            if(checkIdentityNumber(candidateRequest.getIdentityNumber()) == null){
                if (checkEmail(candidateRequest.getEmail()) == null){
                    if(fakeEmailVerificationService.sendEmail(candidateRequest.getEmail())){

                        User user = new User(candidateRequest.getEmail(), candidateRequest.getPassword());

                        Candidate candidate = Candidate.builder()
                                .name(candidateRequest.getName())
                                .surname(candidateRequest.getSurname())
                                .identityNumber(candidateRequest.getIdentityNumber())
                                .dateOfBirth(candidateRequest.getDateOfBirth())
                                .user(user)
                                .build();

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