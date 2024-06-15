package com.cargaexplosiva.api.infra.security.userdetails;

import com.cargaexplosiva.api.model.Funcionario;
import com.cargaexplosiva.api.model.FuncionarioRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class JWTUserDetails implements UserDetails{

    private final Funcionario funcionario;

    public JWTUserDetails(Funcionario funcionario) {
        this.funcionario = funcionario;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (funcionario.getRole() == FuncionarioRole.ADMINISTRADOR) {
            return List.of(new SimpleGrantedAuthority(FuncionarioRole.ADMINISTRADOR.name()),
                    new SimpleGrantedAuthority(FuncionarioRole.GERENTE_MECANICO.name()),
                    new SimpleGrantedAuthority(FuncionarioRole.GERENTE_FROTA.name()),
                    new SimpleGrantedAuthority(FuncionarioRole.MOTORISTA.name()),
                    new SimpleGrantedAuthority(FuncionarioRole.MECANICO.name()));
        } else if (funcionario.getRole() == FuncionarioRole.GERENTE_MECANICO) {
            return List.of(new SimpleGrantedAuthority(FuncionarioRole.GERENTE_MECANICO.name()),
                    new SimpleGrantedAuthority(FuncionarioRole.MECANICO.name()));
        }else if(funcionario.getRole() == FuncionarioRole.GERENTE_FROTA){
            return List.of(new SimpleGrantedAuthority(FuncionarioRole.GERENTE_FROTA.name()),
                    new SimpleGrantedAuthority(FuncionarioRole.MOTORISTA.name()));
        }else if(funcionario.getRole() == FuncionarioRole.MOTORISTA){
            return List.of(new SimpleGrantedAuthority(FuncionarioRole.MOTORISTA.name()));
        }else if(funcionario.getRole() == FuncionarioRole.MECANICO){
            return List.of(new SimpleGrantedAuthority(FuncionarioRole.MECANICO.name()));
        }else return List.of();
    }

    @Override
    public String getPassword() {
        return funcionario.getPassword();
    }

    @Override
    public String getUsername() {
        return funcionario.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
