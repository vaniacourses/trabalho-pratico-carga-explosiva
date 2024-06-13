package com.cargaexplosiva.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Funcionario extends Endereco implements UserDetails,
        Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_funcionario;

    private int numCPF;
    private String nome;
    private String sobrenome;
    private Date dataNascimento;
    private String email;
    private String password;
    private String numRG;
    private int telefone;
    private FuncionarioRole role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.getRole() == FuncionarioRole.ADMINISTRADOR) {
            return List.of(new SimpleGrantedAuthority(FuncionarioRole.ADMINISTRADOR.name()),
                    new SimpleGrantedAuthority(FuncionarioRole.GERENTE_MECANICO.name()),
                    new SimpleGrantedAuthority(FuncionarioRole.GERENTE_FROTA.name()),
                    new SimpleGrantedAuthority(FuncionarioRole.MOTORISTA.name()),
                    new SimpleGrantedAuthority(FuncionarioRole.MECANICO.name()));
        } else if (this.getRole() == FuncionarioRole.GERENTE_MECANICO) {
            return List.of(new SimpleGrantedAuthority(FuncionarioRole.GERENTE_MECANICO.name()),
                    new SimpleGrantedAuthority(FuncionarioRole.MECANICO.name()));
        }else if(this.getRole() == FuncionarioRole.GERENTE_FROTA){
            return List.of(new SimpleGrantedAuthority(FuncionarioRole.GERENTE_FROTA.name()),
                    new SimpleGrantedAuthority(FuncionarioRole.MOTORISTA.name()));
        }else if(this.getRole() == FuncionarioRole.MOTORISTA){
            return List.of(new SimpleGrantedAuthority(FuncionarioRole.MOTORISTA.name()));
        }else if(this.getRole() == FuncionarioRole.MECANICO){
            return List.of(new SimpleGrantedAuthority(FuncionarioRole.MECANICO.name()));
        }else return List.of();
    }

    @Override
    public String getUsername() {
        return this.email;
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
