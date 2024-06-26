package com.cargaexplosiva.api.dto;

import com.cargaexplosiva.api.model.ItemDoEstoque;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record responseItemDoEstoqueDTO(
        @NotNull UUID id_item,
        @NotBlank String nome,
        @NotBlank String tipo,
        @NotBlank String marca
) {
    public responseItemDoEstoqueDTO(ItemDoEstoque item){
        this(item.getId_item(),item.getNome(),item.getTipo(),item.getMarca());
    }
}
