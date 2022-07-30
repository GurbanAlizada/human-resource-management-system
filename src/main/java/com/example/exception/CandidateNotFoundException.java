package com.example.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CandidateNotFoundException extends RuntimeException {

    public CandidateNotFoundException(String message) {
        super(message);
    }



}
