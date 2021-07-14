package com.alexandre.tryn5.service;

import java.util.List;

import com.alexandre.tryn5.model.User;

import org.springframework.http.ResponseEntity;





public interface LogInService {
    
    public List<User> GetAll();

    public ResponseEntity<?> GetByExample(User user);

    public User GetById(String id);

    public User CreateUser(User user);

    public User UpdateUser(User user, String username);
}
