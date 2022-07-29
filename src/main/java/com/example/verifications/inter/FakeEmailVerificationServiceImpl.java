package com.example.verifications.inter;

import com.example.model.VerificationCode;
import com.example.verifications.impl.FakeEmailVerificationServiceInter;
import org.springframework.stereotype.Component;


@Component
public class FakeEmailVerificationServiceImpl implements FakeEmailVerificationServiceInter {


    @Override
    public boolean sendEmail(VerificationCode verificationCode) {


        if(verificationCode.getCode()>1000){
            verificationCode.setVerified(true);
            return true;
        }

        return false;
    }


}
