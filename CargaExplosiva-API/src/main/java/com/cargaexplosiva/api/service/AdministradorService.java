package com.cargaexplosiva.api.service;

import com.cargaexplosiva.api.model.Administrador;
import com.cargaexplosiva.api.repository.AdministradorRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
@Transactional
public class AdministradorService {

    final AdministradorRepository administradorRepository;

    public AdministradorService(AdministradorRepository administradorRepository) {
        this.administradorRepository = administradorRepository;
    }

    public void save() {
        Administrador administrador = new Administrador();
        administrador.setPassword(new BCryptPasswordEncoder().encode("123456"));
        administradorRepository.save(administrador);
    }
}
