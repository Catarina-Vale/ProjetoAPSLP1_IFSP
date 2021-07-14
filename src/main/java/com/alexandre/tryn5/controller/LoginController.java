package com.alexandre.tryn5.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.alexandre.tryn5.model.User;
import com.alexandre.tryn5.service.LogInService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class LoginController {
    @Autowired
    private LogInService loginService;

    @GetMapping(value="/login")
    public ResponseEntity<?> getOne(@RequestBody User user){
       return this.loginService.GetByExample(user);
    }

    @GetMapping(value="/login/testall")
    public List<User> getAllUsers() {
        return this.loginService.GetAll();
    }
        


    @PostMapping(value="/login") 
    public User createUser(@RequestBody User user){
        return this.loginService.CreateUser(user);
    }


}