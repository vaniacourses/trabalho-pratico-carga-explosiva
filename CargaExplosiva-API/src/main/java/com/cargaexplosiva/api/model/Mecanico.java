package com.cargaexplosiva.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "mecanico")
public class Mecanico extends Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;

    private String experienciaProficional;
    private Date dataContratacao;
}
