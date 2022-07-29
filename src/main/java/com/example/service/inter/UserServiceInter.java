package com.example.service.inter;

import com.example.dtos.request.UserRequest;
import com.example.model.User;

public interface UserServiceInter {

    User getByEmail(String email);

    User getByEmailAndPasword(String email , String password);

    User add(UserRequest userRequest);




}
