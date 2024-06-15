package com.cargaexplosiva.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "mecanico")
public class Mecanico extends Funcionario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ManyToMany
    @JoinTable(
            name = "mecanico-especialidade",
            joinColumns = @JoinColumn(name = "id_mecanico"),
            inverseJoinColumns = @JoinColumn(name = "id_especialidade")
    )
    private Set<EspecialidadeMecanica> especialidadeMecanicas = new HashSet<>();

}
