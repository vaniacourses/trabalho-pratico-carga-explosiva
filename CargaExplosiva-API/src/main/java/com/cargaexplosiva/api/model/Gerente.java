package com.cargaexplosiva.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "gerente")
public class Gerente extends Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date dataContratcao;
    private Date dataTermine;

}
