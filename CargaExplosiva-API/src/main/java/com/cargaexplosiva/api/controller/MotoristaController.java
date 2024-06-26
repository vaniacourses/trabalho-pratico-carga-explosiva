package com.cargaexplosiva.api.controller;

import com.cargaexplosiva.api.dto.responseOneMotorista;
import org.springframework.web.bind.annotation.RestController;

import com.cargaexplosiva.api.dto.requestUpdateMotoristaDTO;
import com.cargaexplosiva.api.dto.requestUpdateVeiculoDTO;
import com.cargaexplosiva.api.dto.responseOneVeiculo;
import com.cargaexplosiva.api.model.Motorista;
import com.cargaexplosiva.api.service.MotoristaService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("motorista")
public class MotoristaController {

    private final MotoristaService motoristaService;

    public MotoristaController(MotoristaService motoristaService) {
        this.motoristaService = motoristaService;
    }

    @GetMapping("/{numCPF}")
      public ResponseEntity<Object> getMotorista(@PathVariable(value = "numCPF") String numCPF){
        return motoristaService.getOne(numCPF);
    }

    @GetMapping
    public ResponseEntity<List<responseOneMotorista>> getAllMotorista(){
        return ResponseEntity.status(HttpStatus.OK).body(motoristaService.getAll());
    }

    @PutMapping
    public ResponseEntity<Object> updateVeiculo(@RequestBody @Valid requestUpdateMotoristaDTO motoristaDTO){
        return motoristaService.update(motoristaDTO);
    }

    @DeleteMapping("/{numCPF}")
    public ResponseEntity<Object> deleteVeiculo(@PathVariable(value = "numCPF") String numCPF){
        motoristaService.delete(numCPF);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
