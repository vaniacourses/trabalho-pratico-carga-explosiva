package com.cargaexplosiva.api.controller;

import com.cargaexplosiva.api.dto.requestRegisterGerenteDTO;
import com.cargaexplosiva.api.dto.requestUpdateGerenteDTO;
import com.cargaexplosiva.api.model.*;
import com.cargaexplosiva.api.service.AtribuicaoVeiculoMotoristaService;
import com.cargaexplosiva.api.service.GerenteService;
import com.cargaexplosiva.api.service.MotoristaService;
import com.cargaexplosiva.api.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("gerente")
public class GerenteController{

    private final GerenteService gerenteService;

    public GerenteController(GerenteService gerenteService) {
        this.gerenteService = gerenteService;
    }

    @PostMapping
    public ResponseEntity<Object> saveGerente(@RequestBody @Valid requestRegisterGerenteDTO gerenteDTO) {
        try {
            gerenteService.saveGerenteFrota(gerenteDTO); // Ou saveGerenteMecanico(gerenteDTO) conforme necessário
            return ResponseEntity.status(HttpStatus.CREATED).body("Gerente criado com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar gerente.");
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getGerente(@PathVariable(value = "id") UUID id) {
        return gerenteService.getById(id);
    }


    @GetMapping("/email")
    public ResponseEntity<Object> getGerenteByEmail(@RequestParam String email) {
        return gerenteService.getByEmail(email);
    }

    @PutMapping
    public ResponseEntity<Object> updateGerente(@RequestBody @Valid requestUpdateGerenteDTO gerenteDTO) {
        return gerenteService.update(gerenteDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteGerente(@PathVariable(value = "id") UUID id) {
        gerenteService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
