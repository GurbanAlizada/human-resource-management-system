package com.example.controller;

import com.example.model.User;
import com.example.service.inter.UserServiceInter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UsersController {


    private final UserServiceInter userServiceInter;

    public UsersController(UserServiceInter userServiceInter) {
        this.userServiceInter = userServiceInter;
    }

    @GetMapping("/getByEmail")
    public ResponseEntity<User> getByEmail(@RequestParam("email") String email) {
       return ResponseEntity.ok(userServiceInter.getByEmail(email));
    }


    @GetMapping("/getByEmailAndPasword")
    public ResponseEntity<User>
    getByEmailAndPasword(@RequestParam("email") String email,
                         @RequestParam("password") String password) {
        return ResponseEntity.ok(userServiceInter.getByEmailAndPasword(email, password));
    }







}
