package com.alexandre.tryn5.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.alexandre.tryn5.model.Paciente;
import com.alexandre.tryn5.model.Procedimento;
import com.alexandre.tryn5.repository.PacienteRepository;
import com.alexandre.tryn5.service.PacienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceimpl implements PacienteService{

    @Autowired
    private PacienteRepository pacienteRepo;

    @Override
    public List<Paciente> GetAll() {

        return this.pacienteRepo.findAll();
    }

    @Override
    public Paciente GetByExample(Paciente paciente) {

        final Example<Paciente> example = Example.of(paciente);
        final Optional<Paciente> dbuser = this.pacienteRepo.findOne(example);
        if(dbuser.isPresent()){
            return dbuser.get();
        }
        else{
            return null;
        }
    }


    @Override
    public Paciente UpdatePaciente(String cpf, Paciente newPacienteInfo) {
        
        Paciente oldPaciente = new Paciente();
        oldPaciente.setCpf(cpf);
        final Example<Paciente> example = Example.of(oldPaciente);
        final Optional<Paciente> dbuser = this.pacienteRepo.findOne(example);
        if(dbuser.isPresent()){
            Paciente pacienteASalvar = dbuser.get();
            pacienteASalvar.setNome(newPacienteInfo.getNome() != null ? newPacienteInfo.getNome() : pacienteASalvar.getNome());
            pacienteASalvar.setRg(newPacienteInfo.getRg() != null ? newPacienteInfo.getRg() : pacienteASalvar.getRg());
            pacienteASalvar.setCpf(newPacienteInfo.getCpf() != null ? newPacienteInfo.getCpf() : pacienteASalvar.getCpf());
            pacienteASalvar.setNomeMae(newPacienteInfo.getNomeMae() != null ? newPacienteInfo.getNomeMae() : pacienteASalvar.getNomeMae());
            pacienteASalvar.setNomePai(newPacienteInfo.getNomePai() != null ? newPacienteInfo.getNomePai() : pacienteASalvar.getNomePai());
            pacienteASalvar.setIdade(newPacienteInfo.getIdade() != null ? newPacienteInfo.getIdade() : pacienteASalvar.getIdade());
            pacienteASalvar.setContato(newPacienteInfo.getContato() != null ? newPacienteInfo.getContato() : pacienteASalvar.getContato());
            pacienteASalvar.setConvenio(newPacienteInfo.getConvenio() != null ? newPacienteInfo.getConvenio() : pacienteASalvar.getConvenio());
            pacienteASalvar.setEndereco(newPacienteInfo.getEndereco() != null ? newPacienteInfo.getEndereco() : pacienteASalvar.getEndereco());
            pacienteASalvar.setProcedimento(newPacienteInfo.getProcedimento() != null ? newPacienteInfo.getProcedimento() : pacienteASalvar.getProcedimento());
            pacienteASalvar.setAlergia(newPacienteInfo.getAlergia() != null ? newPacienteInfo.getAlergia() : pacienteASalvar.getAlergia());
            return this.pacienteRepo.save(pacienteASalvar);
        }
        else{
            return null;
        }
    }

    @Override
    public Paciente CreatePaciente(Paciente paciente) {

        return this.pacienteRepo.save(paciente);
    }

    @Override
    public Paciente AddProcedimento(String cpf, Procedimento procedimento) {

        Paciente oldPaciente = new Paciente();
        oldPaciente.setCpf(cpf);
        final Example<Paciente> example = Example.of(oldPaciente);
        final Optional<Paciente> dbuser = this.pacienteRepo.findOne(example);
        if(dbuser.isPresent()){
            Paciente pacienteASalvar = dbuser.get();
            if(pacienteASalvar.getProcedimento() == null){
                ArrayList<Procedimento> mylist = new ArrayList<Procedimento>();
                mylist.add(procedimento);
                pacienteASalvar.setProcedimento(mylist);
            }else{
                ArrayList<Procedimento> mylist = new ArrayList<Procedimento>();
                mylist.addAll(pacienteASalvar.getProcedimento());
                mylist.add(procedimento);
                pacienteASalvar.setProcedimento(mylist);
            }
            return this.pacienteRepo.save(pacienteASalvar);
        }
        else{
            return null;
        }
    }
    
}
