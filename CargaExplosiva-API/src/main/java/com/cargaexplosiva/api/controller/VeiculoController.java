package com.cargaexplosiva.api.controller;

import com.cargaexplosiva.api.dto.requestSaveVeiculoDTO;
import com.cargaexplosiva.api.dto.requestUpdateVeiculoDTO;
import com.cargaexplosiva.api.dto.responseOneVeiculo;
import com.cargaexplosiva.api.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        try {
            var veiculo = veiculoService.save(veiculoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(veiculo);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar veiculo.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getVeiculo(@PathVariable(value = "id") UUID id){
        return veiculoService.getOne(id);
    }

    @GetMapping
    public ResponseEntity<List<responseOneVeiculo>> getAllVeiculo(){
        return ResponseEntity.status(HttpStatus.OK).body(veiculoService.getAll());
    }

    @PutMapping
    public ResponseEntity<Object> updateVeiculo(@RequestBody @Valid requestUpdateVeiculoDTO veiculoDTO){
        return veiculoService.update(veiculoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVeiculo(@PathVariable(value = "id") UUID id_veiculo){
        veiculoService.delete(id_veiculo);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
