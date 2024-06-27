package com.cargaexplosiva.api.dto;

import com.cargaexplosiva.api.model.Motorista;
import com.cargaexplosiva.api.model.Veiculo;

import java.sql.Timestamp;
import java.util.UUID;

public record requestSaveAtribuicaoVeiculoMotoristaDTO(
        Timestamp dataInicio,
        Timestamp dataFim,
        UUID id_funcionario,
        UUID id_veiculo
){}