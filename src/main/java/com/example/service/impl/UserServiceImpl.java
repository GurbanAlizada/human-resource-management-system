package com.example.service.impl;

import com.example.dtos.request.UserRequest;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.inter.UserServiceInter;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServiceInter {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    @Override
    public User getByEmailAndPasword(String email, String password) {
        return userRepository.getByEmailAndPasword(email, password);
    }


    @Override
    public User add(UserRequest userRequest) {
        User user = new User(0 , userRequest.getEmail(), userRequest.getPassword());
        return userRepository.save(user);
    }




}
