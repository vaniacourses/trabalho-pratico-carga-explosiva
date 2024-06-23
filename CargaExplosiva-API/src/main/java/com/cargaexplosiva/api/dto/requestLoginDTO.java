package com.cargaexplosiva.api.dto;

import jakarta.validation.constraints.NotBlank;

public record requestLoginDTO(
        @NotBlank String email,
        @NotBlank String password
){}
