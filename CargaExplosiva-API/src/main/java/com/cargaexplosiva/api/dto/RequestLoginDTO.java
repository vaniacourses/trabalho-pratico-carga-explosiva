package com.cargaexplosiva.api.dto;

import jakarta.validation.constraints.NotBlank;

public record RequestLoginDTO(
        @NotBlank String email,
        @NotBlank String password
) {
}
