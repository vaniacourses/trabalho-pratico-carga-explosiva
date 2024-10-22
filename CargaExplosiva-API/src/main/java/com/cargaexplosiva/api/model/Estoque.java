package com.cargaexplosiva.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "estoque")
public class Estoque implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_estoque;
    @Column(columnDefinition = "integer default 0")
    private int quantidade;
    @Column(columnDefinition = "float default 0")
    private float valor_unitario;
    @OneToOne
    @JoinColumn(name = "id_item", nullable = false)
    private ItemDoEstoque itemDoEstoque;
}
