package com.cargaexplosiva.api.model;

import jakarta.persistence.Entity;
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

    public Administrador() {
        this.setNome("Fulano");
        this.setSobrenome("De Tal");
        this.setEmail("fulano@gmail.com");
        this.setRole(FuncionarioRole.ADMINISTRADOR);
        this.setNumRG("123456789");
        this.setNumCPF("999.999.999-00");
        this.setDataNascimento(Date.valueOf("1111-11-11"));
        this.setRua("Rua dos Bobos");
        this.setNumero(0);
        this.setBairro("Bairro do Fulano");
        this.setCidade("Cidade do Fulano");
        this.setPais("Brasil");
        this.setCep(99999999);
    }
}
