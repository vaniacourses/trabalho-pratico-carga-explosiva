package com.cargaexplosiva.api.dto;

import jakarta.validation.constraints.NotNull;

import lombok.Setter;
import lombok.Getter;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class requestUpdateOSExternaDTO {
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
    private UUID veiculoId;
    @NotNull
    private UUID oficinaId;
    private Set<UUID> servicoIds;

    // Construtor padrão
    public requestUpdateOSExternaDTO() {
    }

    public requestUpdateOSExternaDTO(UUID id, Long codigo, Date dataInicio, Date dataFim, String tipo, float valor, String descricao, char status, float km, UUID veiculoId, UUID oficinaId, Set<UUID> servicoIds) {
        this.id = id;
        this.codigo = codigo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.tipo = tipo;
        this.valor = valor;
        this.descricao = descricao;
        this.status = status;
        this.km = km;
        this.veiculoId = veiculoId;
        this.oficinaId = oficinaId;
        this.servicoIds = servicoIds;
    }

}