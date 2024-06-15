package com.cargaexplosiva.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Year;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "veiculo")
public class Veiculo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_veiculo;
    @Column(nullable = false, unique = true)
    private String placa;
    @Column(nullable = false)
    private String marca;
    @Column(nullable = false)
    private String modelo;
    @Column(nullable = false)
    private Year AnoFabricacao;
    @Column(nullable = false)
    private Year anoModelo;
    @Column(nullable = false)
    private String tipo;
    @Column(nullable = false, unique = true)
    private long numRenavan;
    @Column(nullable = false)
    private int capacidadeCarga;
    @Column(nullable = false, length = 30, unique = true)
    private String numChassi;
    private float totalKM;
    @Column(nullable = false)
    private boolean status;
    @Column(nullable = false)
    private Date dataAdicao;
    private float valor;
    @OneToMany(mappedBy = "veiculo", fetch = FetchType.LAZY)
    private Set<AtribuicaoVeiculoMotorista> atribuicaoVeiculoMotoristaSet =
            new HashSet<>();
    @OneToMany(mappedBy = "veiculo", fetch = FetchType.LAZY)
    private Set<Multa> multas = new HashSet<>();
}
