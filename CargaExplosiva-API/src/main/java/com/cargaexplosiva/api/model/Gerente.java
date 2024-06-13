package com.cargaexplosiva.api.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Entity(name = "gerente")
public class Gerente extends Funcionario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public Collection<GrantedAuthority> getAuthorities() {
        if (this.getRole() == FuncionarioRole.GERENTE_MECANICO) {
            return List.of(new SimpleGrantedAuthority(FuncionarioRole.GERENTE_MECANICO.name()),
                    new SimpleGrantedAuthority(FuncionarioRole.MECANICO.name()));
        }else if(this.getRole() == FuncionarioRole.GERENTE_FROTA){
            return List.of(new SimpleGrantedAuthority(FuncionarioRole.GERENTE_FROTA.name()),
                    new SimpleGrantedAuthority(FuncionarioRole.MOTORISTA.name()));
        }else return List.of();
    }

}
