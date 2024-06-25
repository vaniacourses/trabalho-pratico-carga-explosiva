package com.cargaexplosiva.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "controle_presenca")
public class ControlePresenca implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Transient
    private HorasTrabalhadas calculadora;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_presenca;
    @Column(nullable = false)
    private Timestamp entrada;
    private Timestamp saida;
    private float horasDeTrabalhos;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "id_motorista", nullable = false)
    private Motorista motorista;

    public ControlePresenca(Motorista motorista, Timestamp entrada,
                            HorasTrabalhadas calculadora){
        this.entrada = entrada;
        this.motorista = motorista;
        this.calculadora = calculadora;
    }

    public void calcularHorasTrabalhadas(HorasTrabalhadas calculadora){
        this.calculadora = calculadora;
        this.horasDeTrabalhos = this.calcular();
    }

    private float calcular(){
        return this.calculadora.getHorasTrabalhadas(this);
    }
}
