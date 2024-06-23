package com.cargaexplosiva.api.dto;

import com.cargaexplosiva.api.model.Motorista;
import com.cargaexplosiva.api.model.Veiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record AbastecimentoRecordDTO(@NotNull Date data, @NotNull float valor, @NotBlank String tipo,
                                     @NotNull float km, @NotBlank String notaFiscal,
                                     @NotNull float volume, Motorista motorista, Veiculo veiculo) {
}
