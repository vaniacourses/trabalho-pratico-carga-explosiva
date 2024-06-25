package com.cargaexplosiva.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public record requestRegisterGerenteDTO(
        @NotNull String numCPF,
        @NotBlank String nome,
        @NotBlank String sobrenome,
        @NotNull Date dataNascimento,
        @NotBlank String email,
        @NotBlank String password,
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
){}
