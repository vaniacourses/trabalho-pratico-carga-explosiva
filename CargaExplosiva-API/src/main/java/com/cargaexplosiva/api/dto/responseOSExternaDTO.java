package com.cargaexplosiva.api.dto;

import com.cargaexplosiva.api.model.OSExterna;
import com.cargaexplosiva.api.model.Oficina;
import com.cargaexplosiva.api.model.Servico;
import com.cargaexplosiva.api.model.Veiculo;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

public record responseOSExternaDTO(
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
        Oficina oficina,
        Set<Servico> servicos
) {
    public responseOSExternaDTO(OSExterna osExterna) {
        this(
                osExterna.getId_ordem(),
                osExterna.getCodigo(),
                osExterna.getDataInicio(),
                osExterna.getDataFim(),
                osExterna.getTipo(),
                osExterna.getValor(),
                osExterna.getDescricao(),
                osExterna.getStatus(),
                osExterna.getKm(),
                osExterna.getVeiculo(),
                osExterna.getOficina(),
                osExterna.getServicos()
        );
    }
}