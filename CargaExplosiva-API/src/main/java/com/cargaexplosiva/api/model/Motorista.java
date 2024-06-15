package com.cargaexplosiva.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "motorista")
public class Motorista extends Funcionario implements Serializable{

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(unique = true, nullable = false)
    private long numCNH;
    @Column(nullable = false, columnDefinition = "date")
    private Date validadeCNH;
    @Column(nullable = false, length = 2)
    private String tipoCNH;
    @Column(nullable = false)
    private int pontoCNH;
    private String CNH;
    private boolean ativo;
    @OneToMany(mappedBy = "motorista", fetch = FetchType.LAZY)
    private Set<AtribuicaoVeiculoMotorista> atribuicaoVeiculoMotoristas =
            new HashSet<>();
    @OneToMany(mappedBy = "motorista", fetch = FetchType.LAZY)
    private Set<Multa> multas = new HashSet<>();

}
