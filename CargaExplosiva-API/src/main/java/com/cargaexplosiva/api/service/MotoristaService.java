package com.cargaexplosiva.api.service;

import com.cargaexplosiva.api.dto.requestRegisterGerenteDTO;
import com.cargaexplosiva.api.model.FuncionarioRole;
import com.cargaexplosiva.api.model.Motorista;
import com.cargaexplosiva.api.repository.MotoristaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    public void save(requestRegisterGerenteDTO motoristaDTO){
        var motorista = new Motorista();
        BeanUtils.copyProperties(motoristaDTO, motorista);
        motorista.setPassword(new BCryptPasswordEncoder().encode(motoristaDTO.password()));
        motorista.setRole(FuncionarioRole.MOTORISTA);
        motorista.setAtivo(true);
        motoristaRepository.save(motorista);
    }

    public Motorista find(String username){
        var motoristaOptional = motoristaRepository.findByEmail(username);
        return motoristaOptional.orElse(null);
    }
}
