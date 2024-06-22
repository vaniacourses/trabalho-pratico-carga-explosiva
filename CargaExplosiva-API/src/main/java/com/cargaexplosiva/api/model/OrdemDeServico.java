package com.cargaexplosiva.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class OrdemDeServico implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_ordem;
    private Long codigo;
    @Column(nullable = false)
    private Date dataInicio;
    private Date dataFim;
    private String tipo;
    private float valor;
    private String descricao;
    private char status;
    private float km;
    @ManyToOne
    @JoinColumn(name = "id_veiculo", nullable = false)
    private Veiculo veiculo;
    @ManyToMany
    @JoinTable(name = "os-servicos")
    private Set<Servico> servicos;
}
