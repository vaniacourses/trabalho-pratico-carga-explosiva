package com.cargaexplosiva.api.dto;

import com.cargaexplosiva.api.model.Veiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;

import java.time.Year;
import java.util.Date;

public record requestSaveVeiculoDTO(
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
){}
