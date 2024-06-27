package com.cargaexplosiva.api.dto;

import com.cargaexplosiva.api.model.AtribuicaoVeiculoMotorista;
import com.cargaexplosiva.api.model.Motorista;
import com.cargaexplosiva.api.model.Veiculo;

import java.sql.Timestamp;
import java.util.UUID;

public record responseSaveAtribuicaoVeiculoMotoristaDTO(
        UUID idVeiculoMotorista,
        Timestamp dataInicio,
        Timestamp dataFim,
        Motorista id_funcionario,
        Veiculo id_veiculo
) {
    public responseSaveAtribuicaoVeiculoMotoristaDTO(AtribuicaoVeiculoMotorista atribuicaoVeiculoMotorista){
        this(atribuicaoVeiculoMotorista.getId_VeiculoMotorista(),
                atribuicaoVeiculoMotorista.getDataInicio(),
                atribuicaoVeiculoMotorista.getDataFim(),
                atribuicaoVeiculoMotorista.getMotorista(),
                atribuicaoVeiculoMotorista.getVeiculo());
    }
}
