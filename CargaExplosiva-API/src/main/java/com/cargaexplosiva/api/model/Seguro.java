package com.cargaexplosiva.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "seguro")
public class Seguro extends Endereco implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_seguro;
    @Column(nullable = false)
    private int numContrato;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private int CNPJ;
    @Column(nullable = false)
    private Date dataContratacao;
    private Date DataTerminoContrato;
    private float franquia;
    private float valorMaximoAssegurado;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(mappedBy = "seguros", fetch = FetchType.LAZY)
    private Set<Veiculo> veiculos = new HashSet<>();
}
