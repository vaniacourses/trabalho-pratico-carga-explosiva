package com.cargaexplosiva.api.service;

import com.cargaexplosiva.api.infra.configSingleton.AdministradorBensConfig;
import com.cargaexplosiva.api.model.Administrador;
import com.cargaexplosiva.api.repository.AdministradorRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdministradorService {

    final AdministradorRepository administradorRepository;
    final AdministradorBensConfig administradorBensConfig;

    public AdministradorService(AdministradorRepository administradorRepository, AdministradorBensConfig administradorBensConfig) {
        this.administradorRepository = administradorRepository;
        this.administradorBensConfig = administradorBensConfig;
    }

    public void save(){
        Administrador administrador = administradorBensConfig.administrador();
        administrador.setPassword(new BCryptPasswordEncoder().encode("123456"));
        administradorRepository.save(administrador);
    }
}
