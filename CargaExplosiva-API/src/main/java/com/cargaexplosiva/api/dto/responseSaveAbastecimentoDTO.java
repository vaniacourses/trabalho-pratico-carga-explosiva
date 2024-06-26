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
        @NotNull int cep,
        @NotBlank String rua,
        @NotNull int numero,
        String complemento,
        @NotBlank String bairro,
        @NotBlank String cidade,
        @NotBlank String pais,
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
                abastecimento.getCep(),
                abastecimento.getRua(),
                abastecimento.getNumero(),
                abastecimento.getComplemento(),
                abastecimento.getBairro(),
                abastecimento.getCidade(),
                abastecimento.getPais(),
                abastecimento.getMotorista(),
                abastecimento.getVeiculo());
    }
}

