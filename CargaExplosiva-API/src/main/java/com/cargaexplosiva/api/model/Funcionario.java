package com.cargaexplosiva.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Funcionario extends Endereco implements Serializable{

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_funcionario;

    private int numCPF;
    @Column(nullable = false)
    private String nome;
    private String sobrenome;
    private Date dataNascimento;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private String numRG;
    private int telefone;
    private FuncionarioRole role;
    private Date dataContratcao;
    private Date dataTerminoContrato;

}
