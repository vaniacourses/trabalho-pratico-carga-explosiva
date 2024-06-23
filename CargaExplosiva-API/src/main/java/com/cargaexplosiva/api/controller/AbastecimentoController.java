package com.cargaexplosiva.api.controller;

import com.cargaexplosiva.api.dto.AbastecimentoRecordDTO;
import com.cargaexplosiva.api.model.Abastecimento;
import com.cargaexplosiva.api.repository.AbastecimentoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class AbastecimentoController {
    @Autowired
    AbastecimentoRepository abastecimentoRepository;

    @PostMapping("/abastecimentos")
    public ResponseEntity<Abastecimento> saveAbastecimento(@RequestBody @Valid AbastecimentoRecordDTO abastecimentoRecordDTO) {
        var abastecimentoModel = new Abastecimento();
        BeanUtils.copyProperties(abastecimentoRecordDTO, abastecimentoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(abastecimentoRepository.save(abastecimentoModel));
    }

    @GetMapping("/abastecimentos")
    public ResponseEntity<List<Abastecimento>> getAllAbastecimentos() {
        return ResponseEntity.status(HttpStatus.OK).body(abastecimentoRepository.findAll());
    }

    @GetMapping("/abastecimentos/{id}")
    public ResponseEntity<Object> getOneAbastecimento(@PathVariable(value = "id") UUID id) {
        Optional<Abastecimento> abastecimentoO = abastecimentoRepository.findById(id);
        if (abastecimentoO.isEmpty())  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Abastecimento não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(abastecimentoO.get());
    }

    @PutMapping("/abastecimentos/{id}")
    public ResponseEntity<Object> updateAbastecimento(@PathVariable(value = "id") UUID id,
                                                      @RequestBody @Valid AbastecimentoRecordDTO abastecimentoRecordDTO) {
        Optional<Abastecimento> abastecimentoO = abastecimentoRepository.findById(id);
        if (abastecimentoO.isEmpty())  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Abastecimento não encontrado.");
        }
        var abastecimentoModel = abastecimentoO.get();
        BeanUtils.copyProperties(abastecimentoRecordDTO, abastecimentoModel);
        return ResponseEntity.status(HttpStatus.OK).body(abastecimentoRepository.save(abastecimentoModel));
    }

    @DeleteMapping("/abastecimentos/{id}")
    public ResponseEntity<Object> deleteAbastecimento(@PathVariable(value = "id") UUID id) {
        Optional<Abastecimento> abastecimentoO = abastecimentoRepository.findById(id);
        if (abastecimentoO.isEmpty())  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Abastecimento não encontrado.");
        }
        abastecimentoRepository.delete(abastecimentoO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Abastecimento deletado com sucesso.");
    }

}
