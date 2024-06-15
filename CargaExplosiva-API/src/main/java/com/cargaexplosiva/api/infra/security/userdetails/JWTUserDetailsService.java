package com.cargaexplosiva.api.infra.security.userdetails;

import com.cargaexplosiva.api.model.Funcionario;
import com.cargaexplosiva.api.repository.FuncionarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JWTUserDetailsService implements UserDetailsService {

    private final FuncionarioRepository funcionarioRepository;

    public JWTUserDetailsService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Funcionario funcionario = funcionarioRepository.findByEmail(username);
        if(funcionario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado.");
        }
        return new JWTUserDetails(funcionario);
    }
}
