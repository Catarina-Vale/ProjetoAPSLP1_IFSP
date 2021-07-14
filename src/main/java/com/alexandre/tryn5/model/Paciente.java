package com.alexandre.tryn5.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document


public class Paciente {
    
    @Id
    private String id;

    private String nome;
    private String rg;
    private String cpf;
    private String nomeMae;
    private String nomePai;
    private Integer idade;
    private Contato contato;
    private Convenio convenio;
    private Endereco endereco;
    private List<Procedimento> procedimento;
    private List<String> alergia;

}
