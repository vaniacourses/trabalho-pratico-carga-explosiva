package com.cargaexplosiva.api.controller;

import com.cargaexplosiva.api.dto.requestSaveVeiculoDTO;
import com.cargaexplosiva.api.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("veiculo")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @PostMapping
    public ResponseEntity<Object> saveVeiculo(@RequestBody @Valid requestSaveVeiculoDTO veiculoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoService.save(veiculoDTO));
    }
}
