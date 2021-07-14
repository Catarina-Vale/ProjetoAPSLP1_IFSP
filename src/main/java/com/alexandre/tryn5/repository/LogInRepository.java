package com.alexandre.tryn5.repository;

import com.alexandre.tryn5.model.User;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogInRepository extends MongoRepository<User, String> {
    
}
