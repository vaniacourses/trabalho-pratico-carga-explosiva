package com.cargaexplosiva.api.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "motorista")
public class Motorista extends Funcionario implements Serializable{

    @Serial
    private static final long serialVersionUID = 1L;

    private int numCNH;
    private Date validadeCNH;
    private String tipoCNH;
    private int pontoCNH;
    private String experienciaProfissional;
    private String CNH;
    private boolean ativo;

}
