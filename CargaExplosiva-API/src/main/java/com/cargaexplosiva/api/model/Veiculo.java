package com.cargaexplosiva.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Year;
import java.util.*;

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
    private Date dataCompra;
    private float valor;
    @OneToMany(mappedBy = "veiculo", fetch = FetchType.LAZY)
    private Set<AtribuicaoVeiculoMotorista> atribuicaoVeiculoMotoristaSet =
            new HashSet<>();
    @OneToMany(mappedBy = "veiculo", fetch = FetchType.LAZY)
    private Set<Multa> multas = new HashSet<>();
    @OneToMany(mappedBy = "veiculo", fetch = FetchType.LAZY)
    private Set<Abastecimento> abastecimentos = new HashSet<>();
    @OneToMany(mappedBy = "veiculo", fetch = FetchType.LAZY)
    private Set<CRLV> crlvs = new HashSet<>();
    @OneToMany(mappedBy = "veiculo", fetch = FetchType.LAZY)
    private Set<Sinistro> sinistros = new HashSet<>();
    @OneToMany(mappedBy = "veiculo", fetch = FetchType.LAZY)
    private Set<Imagem> imagems = new HashSet<>();
    @OneToMany(mappedBy = "veiculo", fetch = FetchType.LAZY)
    private Set<RelatorioVeiculo> relatorios = new HashSet<>();
    @OneToMany(mappedBy = "veiculo", fetch = FetchType.LAZY)
    private Set<ProblemaRelatado> problemaRelatados = new HashSet<>();
    @OneToMany(mappedBy = "veiculo", fetch = FetchType.LAZY)
    private Set<VerificacaoDoVeiculo> verificacoes = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "veiculo-seguro",
            joinColumns = @JoinColumn(name = "id_veiculo"),
            inverseJoinColumns = @JoinColumn(name = "id_seguro")
    )
    private Set<Seguro> seguros = new HashSet<>();
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "veiculo", fetch = FetchType.LAZY)
    private Set<OSInterna> osInternas = new HashSet<>();
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "veiculo", fetch = FetchType.LAZY)
    private Set<OSExterna> osExternas = new HashSet<>();

    public Veiculo(String placa, String marca, String modelo,
                   Year anoFabricacao, Year anoModelo, String tipo,
                   long numRenavan, int capacidadeCarga, String numChassi,
                   float totalKM, boolean status, Date dataCompra,
                   float valor) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.AnoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.tipo = tipo;
        this.numRenavan = numRenavan;
        this.capacidadeCarga = capacidadeCarga;
        this.numChassi = numChassi;
        this.totalKM = totalKM;
        this.status = status;
        this.dataCompra = dataCompra;
        this.valor = valor;
    }

    public Optional<Motorista> getMotoristaAtual(){
        try {
            return this.getAtribuicaoVeiculoMotoristaSet()
                    .stream()
                    .filter(e -> e.getDataFim() == null)
                    .findFirst()
                    .map(AtribuicaoVeiculoMotorista::getMotorista);
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
