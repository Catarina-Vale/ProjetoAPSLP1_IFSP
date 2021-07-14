package com.alexandre.tryn5.repository;

import com.alexandre.tryn5.model.Paciente;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PacienteRepository extends MongoRepository<Paciente, String> {
    
}
