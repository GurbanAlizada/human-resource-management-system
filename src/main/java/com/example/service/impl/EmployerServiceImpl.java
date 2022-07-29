package com.example.service.impl;

import com.example.dtos.request.EmployerRequest;
import com.example.exception.MernisNotFoundExcpeption;
import com.example.model.Employer;
import com.example.model.User;
import com.example.repository.EmployerRepository;
import com.example.service.inter.EmployerServiceInter;
import com.example.service.inter.UserServiceInter;
import com.example.verifications.inter.FakeEmailVerificationServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class EmployerServiceImpl implements EmployerServiceInter {

    private final EmployerRepository employerRepository;
    private final UserServiceInter userServiceInter;
    private final FakeEmailVerificationServiceImpl fakeEmailVerificationService;

    public EmployerServiceImpl(
            EmployerRepository employerRepository,
            UserServiceInter userServiceInter,
            FakeEmailVerificationServiceImpl fakeEmailVerificationService) {

        this.employerRepository = employerRepository;
        this.userServiceInter = userServiceInter;
        this.fakeEmailVerificationService = fakeEmailVerificationService;
    }



    @Override
    public Employer add(EmployerRequest employerRequest) {

        if(userServiceInter.getByEmail(employerRequest.getEmail())==null){

           if(fakeEmailVerificationService.sendEmail(employerRequest.getEmail())){

               User user = new User(employerRequest.getEmail(), employerRequest.getPassword());

               Employer employer = Employer.builder()
                       .id(0)
                       .companyName(employerRequest.getCompanyName())
                       .webAddress(employerRequest.getWebAddress())
                       .phoneNumber(employerRequest.getPhoneNumber())
                       .user(user)
                       .build();

               return employerRepository.save(employer);

           }else{
               throw new MernisNotFoundExcpeption("Sisstemde zaten bu gmail var");

           }
        }else{
            throw new MernisNotFoundExcpeption("Sisstemde zaten bu gmail var");
        }

    }






}
