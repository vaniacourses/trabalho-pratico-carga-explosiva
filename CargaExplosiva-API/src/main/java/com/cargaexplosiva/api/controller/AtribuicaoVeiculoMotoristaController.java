package com.cargaexplosiva.api.controller;

import com.cargaexplosiva.api.dto.requestSaveAtribuicaoVeiculoMotoristaDTO;
import com.cargaexplosiva.api.dto.responseSaveAtribuicaoVeiculoMotoristaDTO;
import com.cargaexplosiva.api.service.AtribuicaoVeiculoMotoristaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("atribuir-veiculo-motorista")
public class AtribuicaoVeiculoMotoristaController {

    private final AtribuicaoVeiculoMotoristaService atribuicaoService;

    public AtribuicaoVeiculoMotoristaController(AtribuicaoVeiculoMotoristaService atribuicaoService) {
        this.atribuicaoService = atribuicaoService;
    }

    @PostMapping
    public ResponseEntity<Object> saveAtribuicao(@RequestBody @Valid requestSaveAtribuicaoVeiculoMotoristaDTO dto) {
        try {
            responseSaveAtribuicaoVeiculoMotoristaDTO response = atribuicaoService.save(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}

