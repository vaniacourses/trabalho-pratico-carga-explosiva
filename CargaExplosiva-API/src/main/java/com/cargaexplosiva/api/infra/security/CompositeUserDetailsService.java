package com.cargaexplosiva.api.infra.security;

import com.cargaexplosiva.api.service.GerenteService;
import com.cargaexplosiva.api.service.MecanicoService;
import com.cargaexplosiva.api.service.MotoristaService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CompositeUserDetailsService implements UserDetailsService {

    final GerenteService gerenteService;
    final MecanicoService mecanicoService;
    final MotoristaService motoristaService;

    public CompositeUserDetailsService(GerenteService gerenteService, MecanicoService mecanicoService, MotoristaService motoristaService) {
        this.gerenteService = gerenteService;
        this.mecanicoService = mecanicoService;
        this.motoristaService = motoristaService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            return gerenteService.loadUserByUsername(username);
        }catch (UsernameNotFoundException ignored){

        }try {
            return motoristaService.loadUserByUsername(username);
        }catch (UsernameNotFoundException ignored){

        }try {
            return mecanicoService.loadUserByUsername(username);
        }catch (UsernameNotFoundException ignored){
            throw new UsernameNotFoundException(username);
        }
    }
}
