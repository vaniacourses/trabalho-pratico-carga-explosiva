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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "servico")
public class Servico implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_servico;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String descricao;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(mappedBy = "servicos", fetch = FetchType.LAZY)
    private Set<Oficina> oficinas = new HashSet<>();
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(mappedBy = "servicos", fetch = FetchType.LAZY)
    private Set<OSExterna> osExternas = new HashSet<>();
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(mappedBy = "servicos", fetch = FetchType.LAZY)
    private Set<OSInterna> osInternas = new HashSet<>();
}
