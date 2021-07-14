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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginController {
    @Autowired
    private LogInService loginService;


    // @CrossOrigin(origins = "http://localhost:4200")
    // @GetMapping("/yourPath")
    @PostMapping(value="/login")
    public ResponseEntity<?> getOne(@RequestBody User user){
       return this.loginService.GetByExample(user);
    }

    // @CrossOrigin(origins = "http://localhost:4200")
    // @GetMapping("/yourPath")
    @GetMapping(value="/login/testall")
    public List<User> getAllUsers() {
        return this.loginService.GetAll();
    }
        

    // @CrossOrigin(origins = "http://localhost:4200")
    // @GetMapping("/yourPath")
    @PostMapping(value="/login/cadastro") 
    public User createUser(@RequestBody User user){
        return this.loginService.CreateUser(user);
    }

    // @CrossOrigin(origins = "http://localhost:4200")
    // @GetMapping("/yourPath")
    @PutMapping(value="/login")
    public User updateUser(@RequestBody User user, @RequestParam String username){
       return this.loginService.UpdateUser(user, username);
    }


}