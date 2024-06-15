package com.cargaexplosiva.api.service;

import com.cargaexplosiva.api.model.Gerente;
import com.cargaexplosiva.api.repository.GerenteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GerenteService{

    final GerenteRepository repositoryGerente;

    public GerenteService(GerenteRepository repositoryGerente) {
        this.repositoryGerente = repositoryGerente;
    }

    public void save(Gerente gerente){
        repositoryGerente.save(gerente);
    }
}
