package com.cargaexplosiva.api.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "problema_veiculo")
public class ProblemaVeiculo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_problema;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private String tipo;
    @OneToMany(mappedBy = "problema", fetch = FetchType.LAZY)
    private Set<ProblemaRelatado> problemasRelatados = new HashSet<>();
}
