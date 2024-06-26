package com.cargaexplosiva.api.dto;

import com.cargaexplosiva.api.model.Motorista;
import com.cargaexplosiva.api.model.Veiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record requestSaveAbastecimentoDTO(
        @NotNull Date data,
        @NotNull float valor,
        @NotBlank String tipo,
        @NotNull float km,
        @NotBlank String notaFiscal,
        @NotNull float volume,
        @NotNull int cep,
        @NotBlank String rua,
        @NotNull int numero,
        String complemento,
        @NotBlank String bairro,
        @NotBlank String cidade,
        @NotBlank String pais,
        Motorista motorista,
        Veiculo veiculo
){}
