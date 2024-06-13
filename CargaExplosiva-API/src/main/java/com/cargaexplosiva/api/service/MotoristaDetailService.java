package com.cargaexplosiva.api.service;

import com.cargaexplosiva.api.repository.GerenteRepository;
import com.cargaexplosiva.api.repository.MotoristaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MotoristaDetailService implements UserDetailsService {

    final MotoristaRepository motoristaRepository;

    public MotoristaDetailService(MotoristaRepository motoristaRepository) {
        this.motoristaRepository = motoristaRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var motorista =
                motoristaRepository.findByEmail(username).orElseThrow(
                        () -> new UsernameNotFoundException("Motorista não " +
                                "encontrado."));
        return new org.springframework.security.core.userdetails.User(motorista.getEmail(), motorista.getPassword(), motorista.getAuthorities());
    }
}
