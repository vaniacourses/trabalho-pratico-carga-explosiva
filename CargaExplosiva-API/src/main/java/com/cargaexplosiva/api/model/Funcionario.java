package com.cargaexplosiva.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Funcionario extends Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_funcionario;

    private int numCPF;
    private String nome;
    private String sobrenome;
    private Date dataNascimento;
    private String email;
    private String password;
    private String numRG;
    private int telefone;

}
