package com.cargaexplosiva.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "motorista")
public class Motorista extends Funcionario implements Serializable{

    private static final long serialVersionUID = 1L;

    private int numCNH;
    private Date validadeCNH;
    private String tipoCNH;
    private int pontoCNH;
    private String experienciaProfissional;
    private String CNH;
    private String funcoes;
    private boolean ativo;
}
