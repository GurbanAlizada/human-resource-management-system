package com.example.verifications.impl;

import com.example.model.VerificationCode;

public interface FakeEmailVerificationServiceInter {


    boolean sendEmail(VerificationCode verificationCode);



}
