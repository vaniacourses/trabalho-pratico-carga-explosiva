package com.cargaexplosiva.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@Entity(name = "administrador")
public class Administrador extends Funcionario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public Administrador(){
        this.setNome("Administrador");
        this.setSobrenome("Geral");
        this.setEmail("adm@gmail.com");
        this.setRole(FuncionarioRole.ADMINISTRADOR);
        this.setNumRG("999999999");
        this.setNumCPF("99999999999");
        this.setDataNascimento(Date.valueOf("2024-07-01"));
        this.setRua("Rua dos Bobos");
        this.setNumero(1);
        this.setTelefone(999999999);
        this.setDataContratacao(Date.valueOf("2024-07-01"));
        this.setBairro("Bairro do Fulano");
        this.setCidade("Cidade do Fulano");
        this.setPais("Brasil");
        this.setCep(99999999);
    }

}
