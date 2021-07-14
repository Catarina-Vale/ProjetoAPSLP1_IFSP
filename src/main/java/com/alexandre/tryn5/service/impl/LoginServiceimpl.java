package com.alexandre.tryn5.service.impl;

import java.util.List;
import java.util.Optional;

import com.alexandre.tryn5.model.User;
import com.alexandre.tryn5.repository.LogInRepository;
import com.alexandre.tryn5.service.LogInService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceimpl implements LogInService {
    @Autowired
    private LogInRepository loginRepo;

    @Override
    public List<User> GetAll() {
        
        return this.loginRepo.findAll();
    }

    @Override
    public ResponseEntity<?> GetByExample(User user) {
        final Example<User> example = Example.of(user);
        final Optional<User> dbuser = this.loginRepo.findOne(example);
        if(dbuser.isPresent()){
            return new ResponseEntity<>(dbuser.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public User GetById(String id){
        return this.loginRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found"));
    }

    @Override
    public User CreateUser(User user) {

        return this.loginRepo.save(user);
    }
    
}
