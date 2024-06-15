package com.cargaexplosiva.api.controller;

import com.cargaexplosiva.api.model.Gerente;
import com.cargaexplosiva.api.service.GerenteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("gerente")
public class GerenteController{

    private final GerenteService gerenteService;

    public GerenteController(GerenteService gerenteService) {
        this.gerenteService = gerenteService;
    }

    @GetMapping("/all")
    ResponseEntity<List<Gerente>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(gerenteService.getAll());
    }

}
