package com.cargaexplosiva.api.dto;

import com.cargaexplosiva.api.model.Abastecimento;
import com.cargaexplosiva.api.model.Motorista;
import com.cargaexplosiva.api.model.Veiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.UUID;

public record responseSaveAbastecimentoDTO(
        @NotNull UUID id_abastecimento,
        @NotNull Date data,
        @NotNull float valor,
        @NotBlank String tipo,
        @NotNull float km,
        @NotBlank String notaFiscal,
        @NotNull float volume,
        Motorista motorista,
        Veiculo veiculo
) {
    public responseSaveAbastecimentoDTO(Abastecimento abastecimento){
        this(abastecimento.getId_abastecimento(),
                abastecimento.getData(),
                abastecimento.getValor(),
                abastecimento.getTipo(),
                abastecimento.getKm(),
                abastecimento.getNotaFiscal(),
                abastecimento.getVolume(),
                abastecimento.getMotorista(),
                abastecimento.getVeiculo());
    }
}

