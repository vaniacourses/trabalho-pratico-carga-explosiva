package com.cargaexplosiva.api.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "mecanico")
public class Mecanico extends Funcionario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String experienciaProficional;

    public Collection<GrantedAuthority> getAuthorities() {
        if(this.getRole() == FuncionarioRole.MECANICO){
            return List.of(new SimpleGrantedAuthority(FuncionarioRole.MECANICO.name()));
        }else return List.of();
    }

}
