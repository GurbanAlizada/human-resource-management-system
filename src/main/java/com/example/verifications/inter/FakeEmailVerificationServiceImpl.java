package com.example.verifications.inter;

import com.example.verifications.impl.FakeEmailVerificationServiceInter;
import org.springframework.stereotype.Component;


@Component
public class FakeEmailVerificationServiceImpl implements FakeEmailVerificationServiceInter {


    @Override
    public boolean sendEmail(String email) {


        //
        //
        //


        return true;
    }


}
