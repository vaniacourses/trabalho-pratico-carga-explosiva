package com.cargaexplosiva.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class requestUpdateOSInternaDTO {
    @NotNull
    private UUID id;
    @NotNull
    private Long codigo;
    @NotNull
    private Date dataInicio;
    private Date dataFim;
    @NotNull
    private String tipo;
    private float valor;
    private String descricao;
    private char status;
    private float km;
    @NotNull
    private UUID veiculo;
    private Set<UUID> servicoIds;

    // Construtor padrão
    public requestUpdateOSInternaDTO() {
    }

    public requestUpdateOSInternaDTO(UUID id, Long codigo, Date dataInicio, Date dataFim, String tipo, float valor, String descricao, char status, float km, UUID veiculo, Set<UUID> servicoIds) {
        this.id = id;
        this.codigo = codigo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.tipo = tipo;
        this.valor = valor;
        this.descricao = descricao;
        this.status = status;
        this.km = km;
        this.veiculo = veiculo;
        this.servicoIds = servicoIds;
    }

}