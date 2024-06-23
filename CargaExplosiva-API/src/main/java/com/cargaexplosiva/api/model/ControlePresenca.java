package com.cargaexplosiva.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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

    public ControlePresenca(Timestamp entrada, Motorista motorista) {
        this.entrada = entrada;
        this.motorista = motorista;
    }

    public boolean setSaida(Timestamp saida) {
        if(saida.before(this.entrada)){
            this.saida = saida;
            return true;
        }
        return false;
    }

    public void calcularHorasTrabalhadas(@NotEmpty HorasTrabalhadas calculadora){
        this.setCalculadora(calculadora);
        this.setHorasDeTrabalhos(calcular());
    }

    public float calcular(){
        return this.getCalculadora().getHorasTrabalhadas(this);
    }
}
