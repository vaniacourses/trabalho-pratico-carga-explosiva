package com.cargaexplosiva.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "verificacao_veiculo")
public class VerificacaoDoVeiculo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_verificacao;
    private Timestamp dataHora;
    private String complemento;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "id_motorista", nullable = false)
    private Motorista motorista;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "id_veiculo", nullable = false)
    private Veiculo veiculo;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "verificacao-check_list",
            joinColumns = @JoinColumn(name = "id_verificacao"),
            inverseJoinColumns = @JoinColumn(name = "id_check_list")
    )
    private Set<CheckListVeiculo> checkListsVeiculo;
}
