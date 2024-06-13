package com.cargaexplosiva.api.service;

import com.cargaexplosiva.api.model.Gerente;
import com.cargaexplosiva.api.repository.GerenteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GerenteService implements UserDetailsService {

    final GerenteRepository repositoryGerente;

    public GerenteService(GerenteRepository repositoryGerente) {
        this.repositoryGerente = repositoryGerente;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repositoryGerente.findAllByEmail(username);
    }

    public UserDetails find(String email) {
        return repositoryGerente.findAllByEmail(email);
    }

    public List<Gerente> getAll() {
        return repositoryGerente.findAll();
    }
}
