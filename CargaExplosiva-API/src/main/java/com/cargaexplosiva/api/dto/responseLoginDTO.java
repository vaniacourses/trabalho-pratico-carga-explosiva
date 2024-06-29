package com.cargaexplosiva.api.dto;

import jakarta.validation.constraints.NotBlank;

public record responseLoginDTO(
        responseFuncionarioLoginDTO funcionario,
        @NotBlank String token
){}
