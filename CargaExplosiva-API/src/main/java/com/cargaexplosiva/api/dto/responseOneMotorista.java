package com.cargaexplosiva.api.dto;

import java.sql.Date;
import java.util.Optional;
import java.util.UUID;

import com.cargaexplosiva.api.model.Motorista;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record responseOneMotorista(
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
        @NotBlank String pais,
        @NotNull long numCNH,
        @NotNull Date validadeCNH,
        @NotBlank String tipoCNH,
        int pontoCNH,
        String CNH,
        String funcoes){

    public responseOneMotorista(Motorista motorista){
        this(
                motorista.getId_funcionario(),
                motorista.getNumCPF(),
                motorista.getNome(),
                motorista.getSobrenome(),
                motorista.getDataNascimento(),
                motorista.getEmail(),motorista.getNumRG(),
                motorista.getTelefone(),
                motorista.getExperienciaProfissional(),
                motorista.getDataContratacao(),
                motorista.getDataTerminoContrato(),
                motorista.getCep(),
                motorista.getRua(),
                motorista.getNumero(),
                motorista.getComplemento(),
                motorista.getBairro(),
                motorista.getCidade(),
                motorista.getPais(),
                motorista.getNumCNH(),
                motorista.getValidadeCNH(),
                motorista.getTipoCNH(),
                motorista.getPontoCNH(),
                motorista.getCNH(),
                motorista.getFuncoes()
        );
    }
}
