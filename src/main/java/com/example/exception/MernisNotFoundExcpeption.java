package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MernisNotFoundExcpeption extends RuntimeException{

    public MernisNotFoundExcpeption(String message) {
        super(message);
    }
}
