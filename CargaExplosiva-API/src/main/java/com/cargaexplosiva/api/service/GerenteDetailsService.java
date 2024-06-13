package com.cargaexplosiva.api.service;

import com.cargaexplosiva.api.model.Gerente;
import com.cargaexplosiva.api.repository.GerenteRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class GerenteDetailsService implements UserDetailsService {

    final GerenteRepository gerenteRepository;


    public GerenteDetailsService(GerenteRepository gerenteRepository) {
        this.gerenteRepository = gerenteRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var gerente =
                gerenteRepository.findByEmail(username).orElseThrow(
                        () -> new UsernameNotFoundException("Gerente não " +
                                "encontrado."));
        return new org.springframework.security.core.userdetails.User(gerente.getEmail(), gerente.getPassword(), gerente.getAuthorities());
    }
}
