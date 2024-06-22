package com.cargaexplosiva.api.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Entity(name = "os_interna")
public class OSInterna extends OrdemDeServico implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
