package com.cargaexplosiva.api.dto;

import com.cargaexplosiva.api.model.Funcionario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public record responseFuncionarioLoginDTO(
        @NotBlank String numCPF,
        @NotBlank String nome,
        @NotBlank String sobrenome,
        @NotNull Date dataNascimento,
        @NotBlank String email,
        @NotBlank String role
) {
    public responseFuncionarioLoginDTO(Funcionario funcionario) {
        this(
                funcionario.getNumCPF(),
                funcionario.getNome(),
                funcionario.getSobrenome(),
                funcionario.getDataNascimento(),
                funcionario.getEmail(),
                funcionario.getRole().name()
        );
    }
}
