package com.cargaexplosiva.api.controller;

import com.cargaexplosiva.api.dto.requestSaveVeiculoDTO;
import com.cargaexplosiva.api.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @GetMapping("/{id}")
    public ResponseEntity<Object> getVeiculo(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
