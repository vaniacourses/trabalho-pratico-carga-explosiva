package com.cargaexplosiva.api.service;

import com.cargaexplosiva.api.repository.MotoristaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MotoristaService implements UserDetailsService {

    final MotoristaRepository motoristaRepository;

    public MotoristaService(MotoristaRepository motoristaRepository) {
        this.motoristaRepository = motoristaRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return motoristaRepository.findByEmail(username);
    }

    public UserDetails find(String email) {
        return motoristaRepository.findByEmail(email);
    }
}
