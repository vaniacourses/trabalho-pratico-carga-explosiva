package com.cargaexplosiva.api.service;

import com.cargaexplosiva.api.dto.requestRegisterGerenteDTO;
import com.cargaexplosiva.api.model.FuncionarioRole;
import com.cargaexplosiva.api.model.Gerente;
import com.cargaexplosiva.api.repository.GerenteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GerenteService{

    final GerenteRepository gerenteRepository;

    public GerenteService(GerenteRepository repositoryGerente) {
        this.gerenteRepository = repositoryGerente;
    }

    public void saveGerenteFrota(requestRegisterGerenteDTO gerentDTO){
        var gerente = new Gerente();
        BeanUtils.copyProperties(gerentDTO, gerente);
        gerente.setRole(FuncionarioRole.GERENTE_FROTA);
        gerenteRepository.save(gerente);
    }

    public void saveGerenteMecanico(requestRegisterGerenteDTO gerentDTO){
        var gerente = new Gerente();
        BeanUtils.copyProperties(gerentDTO, gerente);
        gerente.setRole(FuncionarioRole.GERENTE_MECANICO);
        gerenteRepository.save(gerente);
    }
}
