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
import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "motorista")
public class Motorista extends Funcionario implements Serializable{

    @Serial
    private static final long serialVersionUID = 1L;

    private int numCNH;
    private Date validadeCNH;
    private String tipoCNH;
    private int pontoCNH;
    private String experienciaProfissional;
    private String CNH;
    private boolean ativo;

    public Collection<GrantedAuthority> getAuthorities() {
        if(this.getRole() == FuncionarioRole.MOTORISTA){
            return List.of(new SimpleGrantedAuthority(FuncionarioRole.MOTORISTA.name()));
        }else return List.of();
    }

}
