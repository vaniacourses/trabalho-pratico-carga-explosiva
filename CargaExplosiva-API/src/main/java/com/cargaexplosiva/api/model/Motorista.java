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

    private long numCNH;
    private Date validadeCNH;
    @Column(length = 2)
    private String tipoCNH;
    private int pontoCNH;
    private String CNH;
    private String funcoes;
    private boolean ativo;
    @OneToMany(mappedBy = "motorista", fetch = FetchType.LAZY)
    private Set<AtribuicaoVeiculoMotorista> atribuicaoVeiculoMotoristas =
            new HashSet<>();
    @OneToMany(mappedBy = "motorista", fetch = FetchType.LAZY)
    private Set<Multa> multas = new HashSet<>();
    @OneToMany(mappedBy = "motorista", fetch = FetchType.LAZY)
    private Set<ControlePresenca> presencas = new HashSet<>();
    @OneToMany(mappedBy = "motorista", fetch = FetchType.LAZY)
    private Set<RelatorioMotorista> relatorios = new HashSet<>();
    @OneToMany(mappedBy = "motorista", fetch = FetchType.LAZY)
    private Set<Abastecimento> abastecimentos = new HashSet<>();
    @OneToMany(mappedBy = "motorista", fetch = FetchType.LAZY)
    private Set<Sinistro> sinistros = new HashSet<>();
    @OneToMany(mappedBy = "motorista", fetch = FetchType.LAZY)
    private Set<ProblemaRelatado> problemaRelatados = new HashSet<>();
    @OneToMany(mappedBy = "motorista", fetch = FetchType.LAZY)
    private Set<VerificacaoDoVeiculo> verificacoes = new HashSet<>();
}
