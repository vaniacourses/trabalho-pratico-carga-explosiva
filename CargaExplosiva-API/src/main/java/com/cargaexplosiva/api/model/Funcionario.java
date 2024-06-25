package com.cargaexplosiva.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Funcionario extends Endereco implements Serializable{

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_funcionario;

    @Column(unique = true, nullable = false)
    private String numCPF;
    @Column(length = 50)
    private String nome;
    @Column(length = 70)
    private String sobrenome;
    private Date dataNascimento;
    @Column(unique = true)
    private String email;
    private String password;
    @Column(unique = true)
    private String numRG;
    private long telefone;
    private String experienciaProfissional;
    @Column(nullable = false)
    private FuncionarioRole role;
    private Date dataContratacao;
    private Date dataTerminoContrato;
}
