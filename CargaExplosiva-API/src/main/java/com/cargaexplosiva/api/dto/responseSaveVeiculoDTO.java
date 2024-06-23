package com.cargaexplosiva.api.dto;

import com.cargaexplosiva.api.model.Veiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Year;
import java.util.Date;
import java.util.UUID;

public record responseSaveVeiculoDTO(
        @NotNull UUID id_veiculo,
        @NotBlank String placa,
        @NotBlank String marca,
        @NotBlank String modelo,
        @NotNull Year anoFabricacao,
        @NotNull Year anoModelo,
        @NotBlank String tipo,
        @NotNull long numRenavan,
        @NotNull int capacidadeCarga,
        @NotBlank String numChassi,
        @NotNull float totalKM,
        @NotNull boolean status,
        @NotNull Date dataCompra,
        @NotNull float valor
) {
    public responseSaveVeiculoDTO(Veiculo veiculo){
        this(veiculo.getId_veiculo(),
                veiculo.getPlaca(),
                veiculo.getMarca(),
                veiculo.getModelo(),
                veiculo.getAnoFabricacao(),
                veiculo.getAnoModelo(),
                veiculo.getTipo(),
                veiculo.getNumRenavan(),
                veiculo.getCapacidadeCarga(),
                veiculo.getNumChassi(),
                veiculo.getTotalKM(),
                veiculo.isStatus(),
                veiculo.getDataCompra(),
                veiculo.getValor());
    }
}
