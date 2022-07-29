package com.example.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AdvertismentNotFoundException extends RuntimeException{

    public AdvertismentNotFoundException(String message) {
        super(message);
    }


}
