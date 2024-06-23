package com.cargaexplosiva.api.controller;

import com.cargaexplosiva.api.dto.requestSaveAbastecimentoDTO;
import com.cargaexplosiva.api.service.AbastecimentoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("abastecimento")
public class AbastecimentoController {

    private final AbastecimentoService abastecimentoService;

    public AbastecimentoController(AbastecimentoService abastecimentoService) {
        this.abastecimentoService = abastecimentoService;
    }

    @PostMapping
    public ResponseEntity<Object> saveAbastecimento(@RequestBody @Valid requestSaveAbastecimentoDTO abastecimentoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(abastecimentoService.save(abastecimentoDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAbastecimento(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(abastecimentoService.findById(id));
    }

    /*@GetMapping("/veiculo/{veiculoId}")
    public ResponseEntity<List<Abastecimento>> getAbastecimentosByVeiculoId(@PathVariable UUID veiculoId) {
        return ResponseEntity.status(HttpStatus.OK).body(abastecimentoService.findAllByVeiculoId(veiculoId));
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAbastecimento(@PathVariable UUID id) {
        abastecimentoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
