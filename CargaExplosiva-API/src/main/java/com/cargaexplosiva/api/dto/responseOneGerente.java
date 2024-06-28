package com.cargaexplosiva.api.dto;

import com.cargaexplosiva.api.model.Gerente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.UUID;

public record responseOneGerente(
        @NotNull UUID id_funcionario,
        @NotNull String numCPF,
        @NotBlank String nome,
        @NotBlank String sobrenome,
        @NotNull Date dataNascimento,
        @NotBlank String email,
        @NotBlank String numRG,
        @NotNull long telefone,
        @NotBlank String experienciaProfissional,
        @NotNull Date dataContratacao,
        Date dataTerminoContrato,
        @NotNull int cep,
        @NotBlank String rua,
        @NotNull int numero,
        String complemento,
        @NotBlank String bairro,
        @NotBlank String cidade,
        @NotBlank String pais
) {
    public responseOneGerente(Gerente gerente){
        this(
                gerente.getId_funcionario(),
                gerente.getNumCPF(),
                gerente.getNome(),
                gerente.getSobrenome(),
                gerente.getDataNascimento(),
                gerente.getEmail(),
                gerente.getNumRG(),
                gerente.getTelefone(),
                gerente.getExperienciaProfissional(),
                gerente.getDataContratacao(),
                gerente.getDataTerminoContrato(),
                gerente.getCep(),
                gerente.getRua(),
                gerente.getNumero(),
                gerente.getComplemento(),
                gerente.getBairro(),
                gerente.getCidade(),
                gerente.getPais()

        );
    }

}
