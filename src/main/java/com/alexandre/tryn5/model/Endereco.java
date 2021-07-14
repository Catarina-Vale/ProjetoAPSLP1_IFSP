package com.alexandre.tryn5.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document


public class Endereco {
    
    private String nomeLogradouro;
    private Integer nLogradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    
}
