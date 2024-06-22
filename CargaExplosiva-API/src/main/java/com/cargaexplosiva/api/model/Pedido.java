package com.cargaexplosiva.api.model;

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
@Entity(name = "pedido")
public class Pedido implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_pedido;
    @Column(nullable = false)
    private Date data;
    private String motivo;
    private float valorPrevisto;
    @ManyToMany
    @JoinTable(name = "pedido-item")
    private Set<ItemDoEstoque> itens = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "id_gerente", nullable = false)
    private Gerente gerente;

}
