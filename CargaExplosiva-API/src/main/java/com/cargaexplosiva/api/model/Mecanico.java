package com.cargaexplosiva.api.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "mecanico")
public class Mecanico extends Funcionario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String experienciaProficional;

}
