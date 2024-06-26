package com.cargaexplosiva.api.controller;

import com.cargaexplosiva.api.dto.requestSaveAbastecimentoDTO;
import com.cargaexplosiva.api.dto.requestUpdateAbastecimentoDTO;
import com.cargaexplosiva.api.model.Abastecimento;
import com.cargaexplosiva.api.repository.AbastecimentoRepository;
import com.cargaexplosiva.api.service.AbastecimentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("abastecimento")
public class AbastecimentoController {

    @Autowired
    AbastecimentoRepository abastecimentoRepository;
    private final AbastecimentoService abastecimentoService;

    public AbastecimentoController(AbastecimentoService abastecimentoService) {
        this.abastecimentoService = abastecimentoService;
    }

    @PostMapping
    public ResponseEntity<Object> saveAbastecimento(@RequestBody @Valid requestSaveAbastecimentoDTO abastecimentoDTO) {
        try {
            var abastecimento = abastecimentoService.save(abastecimentoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(abastecimento);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar abastecimento.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAbastecimento(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(abastecimentoService.getOne(id));
    }

    @PutMapping
    public ResponseEntity<Object> updateAbastecimento(@RequestBody @Valid requestUpdateAbastecimentoDTO abastecimentoDTO){
        return abastecimentoService.update(abastecimentoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAbastecimento(@PathVariable(value = "id") UUID id) {
        Optional<Abastecimento> abastecimentoO = abastecimentoRepository.findById(id);
        if (abastecimentoO.isEmpty())  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Abastecimento não encontrado.");
        }
        abastecimentoRepository.delete(abastecimentoO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Abastecimento deletado com sucesso.");
    }
}
