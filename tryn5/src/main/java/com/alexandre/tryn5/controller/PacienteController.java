package com.alexandre.tryn5.controller;

import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import com.alexandre.tryn5.model.Paciente;
import com.alexandre.tryn5.model.Procedimento;
import com.alexandre.tryn5.service.PacienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin
@RestController
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping(value="/paciente")
    public Paciente getOne(@RequestBody Paciente paciente){

       return this.pacienteService.GetByExample(paciente);
    }

    @GetMapping(value="/paciente/testall")
    public List<Paciente> getAllPacientes() {

        return this.pacienteService.GetAll();
    }

    @GetMapping(value="/paciente")
    public Paciente getPacienteByCpf(@RequestParam String cpf) {

        return this.pacienteService.GetByCpf(cpf);
    }
        

    @PostMapping(value="/paciente/cadastro") 
    public Paciente createPaciente(@RequestBody Paciente paciente){

        return this.pacienteService.CreatePaciente(paciente);
    }

    @PutMapping(value="/paciente")
    public Paciente UpdatePaciente(@RequestBody Paciente paciente, @RequestParam String cpf){
        
        return this.pacienteService.UpdatePaciente(cpf, paciente);
    }

    @PutMapping(value="/paciente/procedimento")
    public Paciente AddProcedimento(@RequestBody Procedimento procedimento, @RequestParam String cpf){
        
        return this.pacienteService.AddProcedimento(cpf, procedimento);
    }

    @PutMapping(value="/paciente/alergia")
    public Paciente AddAlergia(@RequestParam String cpf, @RequestParam String alergia){
        
        return this.pacienteService.AddAlergia(cpf, alergia);
    }

}
