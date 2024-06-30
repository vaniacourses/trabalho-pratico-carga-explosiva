package com.cargaexplosiva.api.dto;

import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

public record requestSaveOSExternaDTO(
        Long codigo,
        @NotNull Date dataInicio,
        Date dataFim,
        @NotNull String tipo,
        float valor,
        String descricao,
        char status,
        float km,
        @NotNull UUID veiculoId,
        @NotNull UUID oficinaId,
        Set<UUID> servicoIds
) {}