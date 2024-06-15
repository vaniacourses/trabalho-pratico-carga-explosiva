package com.cargaexplosiva.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Endereco {

    @Column(nullable = false)
    private int cep;
    @Column(nullable = false, length = 80)
    private String rua;
    private int numero;
    private String complemento;
    @Column(nullable = false, length = 50)
    private String bairro;
    @Column(nullable = false, length = 50)
    private String cidade;
    @Column(nullable = false, length = 50)
    @Value("Brasil")
    private String pais;

}
