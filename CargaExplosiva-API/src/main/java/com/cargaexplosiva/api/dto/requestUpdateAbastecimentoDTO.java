package com.cargaexplosiva.api.dto;

import com.cargaexplosiva.api.model.Motorista;
import com.cargaexplosiva.api.model.Veiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.UUID;

public record requestUpdateAbastecimentoDTO(
        @NotNull UUID id_abastecimento,
        @NotNull Date data,
        @NotNull float valor,
        @NotBlank String tipo,
        @NotNull float km,
        @NotBlank String notaFiscal,
        @NotNull float volume,
        Motorista motorista,
        Veiculo veiculo
){}
