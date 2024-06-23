package com.cargaexplosiva.api.service;

import com.cargaexplosiva.api.model.AtribuicaoVeiculoMotorista;
import com.cargaexplosiva.api.repository.AtribuicaoVeiculoMotoristaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AtribuicaoVeiculoMotoristaService {

    final AtribuicaoVeiculoMotoristaRepository atribuicaoVeiculoMotoristaRepository;

    public AtribuicaoVeiculoMotoristaService(AtribuicaoVeiculoMotoristaRepository atribuicaoVeiculoMotoristaRepository) {
        this.atribuicaoVeiculoMotoristaRepository = atribuicaoVeiculoMotoristaRepository;
    }

    public void save(AtribuicaoVeiculoMotorista atribuicao){
        atribuicaoVeiculoMotoristaRepository.save(atribuicao);
    }
}
