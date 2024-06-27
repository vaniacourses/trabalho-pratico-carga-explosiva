package com.cargaexplosiva.api.service;

import com.cargaexplosiva.api.dto.requestSaveAtribuicaoVeiculoMotoristaDTO;
import com.cargaexplosiva.api.dto.responseSaveAtribuicaoVeiculoMotoristaDTO;
import com.cargaexplosiva.api.model.AtribuicaoVeiculoMotorista;
import com.cargaexplosiva.api.model.Motorista;
import com.cargaexplosiva.api.model.Veiculo;
import com.cargaexplosiva.api.repository.AtribuicaoVeiculoMotoristaRepository;
import com.cargaexplosiva.api.repository.MotoristaRepository;
import com.cargaexplosiva.api.repository.VeiculoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AtribuicaoVeiculoMotoristaService {

    private final AtribuicaoVeiculoMotoristaRepository atribuicaoRepository;
    private final MotoristaRepository motoristaRepository;
    private final VeiculoRepository veiculoRepository;

    public AtribuicaoVeiculoMotoristaService(AtribuicaoVeiculoMotoristaRepository atribuicaoRepository,
                                             MotoristaRepository motoristaRepository,
                                             VeiculoRepository veiculoRepository) {
        this.atribuicaoRepository = atribuicaoRepository;
        this.motoristaRepository = motoristaRepository;
        this.veiculoRepository = veiculoRepository;
    }

    public responseSaveAtribuicaoVeiculoMotoristaDTO save(requestSaveAtribuicaoVeiculoMotoristaDTO dto) {
        Optional<Motorista> motorista = motoristaRepository.findById(dto.id_funcionario());
        Optional<Veiculo> veiculo = veiculoRepository.findById(dto.id_veiculo());

        if (motorista.isEmpty() || veiculo.isEmpty()) {
            throw new RuntimeException("Motorista ou Veículo não encontrado");
        }

        if (atribuicaoRepository.existsByVeiculoAndDataFimIsNull(veiculo.get())) {
            throw new RuntimeException("Veículo já atribuído a um motorista");
        }

        AtribuicaoVeiculoMotorista atribuicao = new AtribuicaoVeiculoMotorista();
        BeanUtils.copyProperties(dto, atribuicao);
        atribuicao.setMotorista(motorista.get());
        atribuicao.setVeiculo(veiculo.get());

        atribuicao = atribuicaoRepository.save(atribuicao);

        responseSaveAtribuicaoVeiculoMotoristaDTO response = new responseSaveAtribuicaoVeiculoMotoristaDTO(atribuicao);
        BeanUtils.copyProperties(atribuicao, response);

        return response;
    }
}