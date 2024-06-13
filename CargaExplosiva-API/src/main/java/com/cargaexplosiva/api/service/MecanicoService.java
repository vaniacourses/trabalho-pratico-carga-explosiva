package com.cargaexplosiva.api.service;

import com.cargaexplosiva.api.repository.MecanicoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MecanicoService implements UserDetailsService {

    final MecanicoRepository mecanicoRepository;

    public MecanicoService(MecanicoRepository mecanicoRepository) {
        this.mecanicoRepository = mecanicoRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return mecanicoRepository.findAllByEmail(username);
    }

    public UserDetails find(String email) {
        return mecanicoRepository.findAllByEmail(email);

    }
}
