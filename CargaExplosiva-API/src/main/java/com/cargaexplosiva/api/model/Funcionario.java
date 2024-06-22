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

    @Column(nullable = false, unique = true)
    private long numCPF;
    @Column(nullable = false, length = 50)
    private String nome;
    @Column(nullable = false, length = 70)
    private String sobrenome;
    @Column(nullable = false)
    private Date dataNascimento;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String numRG;
    private int telefone;
    private String experienciaProfissional;
    @Column(nullable = false)
    private FuncionarioRole role;
    @Column(nullable = false)
    private Date dataContratacao;
    private Date dataTerminoContrato;

}
