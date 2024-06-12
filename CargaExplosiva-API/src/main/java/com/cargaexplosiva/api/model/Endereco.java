package com.cargaexplosiva.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Endereco {

    private String cep;
    private String rua;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String pais;

}
