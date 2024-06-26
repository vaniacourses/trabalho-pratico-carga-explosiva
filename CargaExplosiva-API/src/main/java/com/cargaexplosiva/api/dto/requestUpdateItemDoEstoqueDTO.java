package com.cargaexplosiva.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record requestUpdateItemDoEstoqueDTO(
        @NotNull UUID id_item,
        @NotBlank String nome,
        @NotBlank String tipo,
        @NotBlank String marca
) {}

