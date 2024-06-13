package com.cargaexplosiva.api.service;

import com.cargaexplosiva.api.repository.GerenteRepository;
import com.cargaexplosiva.api.repository.MecanicoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MecanicoDetailsService implements UserDetailsService {

    final MecanicoRepository mecanicoRepository;


    public MecanicoDetailsService(MecanicoRepository mecanicoRepository) {
        this.mecanicoRepository = mecanicoRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var mecanico =
                mecanicoRepository.findByEmail(username).orElseThrow(
                        () -> new UsernameNotFoundException("Mecanico não " +
                                "encontrado."));
        return new org.springframework.security.core.userdetails.User(mecanico.getEmail(), mecanico.getPassword(), mecanico.getAuthorities());
    }
}
