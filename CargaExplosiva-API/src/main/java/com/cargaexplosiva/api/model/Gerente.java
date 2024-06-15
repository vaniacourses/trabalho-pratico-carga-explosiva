package com.cargaexplosiva.api.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@Entity(name = "gerente")
public class Gerente extends Funcionario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

}
