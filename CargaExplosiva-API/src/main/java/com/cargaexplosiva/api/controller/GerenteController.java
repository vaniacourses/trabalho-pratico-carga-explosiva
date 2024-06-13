package com.cargaexplosiva.api.controller;

import com.cargaexplosiva.api.model.Gerente;
import com.cargaexplosiva.api.service.GerenteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gerente")
public class GerenteController {

    private final GerenteService gerenteService;

    public GerenteController(GerenteService gerenteService) {
        this.gerenteService = gerenteService;
    }

    @PostMapping
    public ResponseEntity<Object> save() {
        return ResponseEntity.status(HttpStatus.CREATED).body("Funcionou");
    }

    @GetMapping
    public ResponseEntity<List<Gerente>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(gerenteService.getAll());
    }
}
