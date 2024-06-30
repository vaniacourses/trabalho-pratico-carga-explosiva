package com.cargaexplosiva.api.dto;

import jakarta.validation.constraints.NotBlank;

public record requestSaveItemDoEstoqueDTO(
        @NotBlank String nome,
        @NotBlank String tipo,
        @NotBlank String marca,
        int quantidade,
        float valor_unitario
) {
}
