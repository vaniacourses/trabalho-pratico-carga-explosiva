package com.cargaexplosiva.api.service;

import com.cargaexplosiva.api.model.Motorista;
import com.cargaexplosiva.api.repository.MotoristaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class MotoristaService{

    final MotoristaRepository motoristaRepository;

    public MotoristaService(MotoristaRepository motoristaRepository) {
        this.motoristaRepository = motoristaRepository;
    }

    public void save(Motorista motorista) {
        motoristaRepository.save(motorista);
    }

    public Motorista find(UUID motorista) {
        return motoristaRepository.findById(motorista).orElse(null);
    }
}
