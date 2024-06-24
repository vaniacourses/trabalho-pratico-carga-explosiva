package com.cargaexplosiva.api.service;

import com.cargaexplosiva.api.dto.*;
import com.cargaexplosiva.api.model.Abastecimento;
import com.cargaexplosiva.api.repository.AbastecimentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class AbastecimentoService {
    final AbastecimentoRepository abastecimentoRepository;

    public AbastecimentoService(AbastecimentoRepository abastecimentoRepository) {
        this.abastecimentoRepository = abastecimentoRepository;
    }

    public Object save(requestSaveAbastecimentoDTO abastecimentoDTO){
        var abastecimento = new Abastecimento();
        BeanUtils.copyProperties(abastecimentoDTO, abastecimento);
        abastecimento = abastecimentoRepository.save(abastecimento);
        return new responseSaveAbastecimentoDTO(abastecimento);
    }

    public ResponseEntity<Object> getOne(UUID id) {
        var abastecimento = abastecimentoRepository.findById(id);
        if (abastecimento.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(abastecimento.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Abastecimento não encontrado.");
        }
    }

    public ResponseEntity<Object> update(requestUpdateAbastecimentoDTO abastecimentoDTO){
        Optional<Abastecimento> abastecimentoO = abastecimentoRepository.findById(abastecimentoDTO.id_abastecimento());
        if (abastecimentoO.isEmpty())  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Abastecimento não encontrado.");
        }
        var abastecimentoModel = abastecimentoO.get();
        BeanUtils.copyProperties(abastecimentoDTO, abastecimentoModel);
        return ResponseEntity.status(HttpStatus.OK).body(abastecimentoRepository.save(abastecimentoModel));
    }

    public void delete(UUID id) {
        abastecimentoRepository.deleteById(id);
    }
}
