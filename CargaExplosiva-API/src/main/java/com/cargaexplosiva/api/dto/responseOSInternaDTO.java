package com.cargaexplosiva.api.dto;

import com.cargaexplosiva.api.model.OSInterna;
import com.cargaexplosiva.api.model.Servico;
import com.cargaexplosiva.api.model.Veiculo;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

public record responseOSInternaDTO(
        UUID id,
        Long codigo,
        Date dataInicio,
        Date dataFim,
        String tipo,
        float valor,
        String descricao,
        char status,
        float km,
        Veiculo veiculo,
        Set<Servico> servicos
) {
    public responseOSInternaDTO(OSInterna osInterna) {
        this(
                osInterna.getId_ordem(),
                osInterna.getCodigo(),
                osInterna.getDataInicio(),
                osInterna.getDataFim(),
                osInterna.getTipo(),
                osInterna.getValor(),
                osInterna.getDescricao(),
                osInterna.getStatus(),
                osInterna.getKm(),
                osInterna.getVeiculo(),
                osInterna.getServicos()
        );
    }
}