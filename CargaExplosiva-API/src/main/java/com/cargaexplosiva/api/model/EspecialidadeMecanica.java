package com.cargaexplosiva.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "especialidade_mecanica")
public class EspecialidadeMecanica implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_EspecialidadeMecanica;
    @Column(unique = true, nullable = false, length = 100)
    private String nome;
    @Column(columnDefinition = "tinytext")
    private String descricao;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(mappedBy = "especialidadeMecanicas", fetch = FetchType.LAZY)
    private Set<Mecanico> mecanicos = new HashSet<>();
}
