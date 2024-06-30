package com.cargaexplosiva.api.service;

import com.cargaexplosiva.api.dto.requestSaveOSInternaDTO;
import com.cargaexplosiva.api.dto.requestUpdateOSInternaDTO;
import com.cargaexplosiva.api.dto.responseOSInternaDTO;
import com.cargaexplosiva.api.model.OSInterna;
import com.cargaexplosiva.api.repository.OSInternaRepository;
import com.cargaexplosiva.api.repository.ServicoRepository;
import com.cargaexplosiva.api.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class OSInternaService {

    @Autowired
    private OSInternaRepository osInternaRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;
    private ServicoRepository servicoRepository;

    @Autowired
    private OSInternaRepository OSInternaRepository;

    public responseOSInternaDTO save(requestSaveOSInternaDTO dto) {
        var osInterna = new OSInterna();
        BeanUtils.copyProperties(dto, osInterna);
        osInterna.setVeiculo(veiculoRepository.findById(dto.veiculoId()).orElseThrow());
        if (dto.servicoIds() != null) {
            osInterna.setServicos(dto.servicoIds().stream()
                    .map(id -> servicoRepository.findById(id).orElseThrow())
                    .collect(Collectors.toSet()));
        }
        osInterna = osInternaRepository.save(osInterna);
        return new responseOSInternaDTO(osInterna);
    }

    public List<responseOSInternaDTO> findAll() {
        return osInternaRepository.findAll().stream()
                .map(responseOSInternaDTO::new)
                .collect(Collectors.toList());
    }

    public ResponseEntity<Object> findById(UUID id) {
        Optional<OSInterna> osInterna = osInternaRepository.findById(id);
        return osInterna.<ResponseEntity<Object>>
                        map(value -> ResponseEntity.status(HttpStatus.OK).body(new responseOSInternaDTO(value)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("OS Interna não encontrada."));
    }


    public ResponseEntity<Object> update(requestUpdateOSInternaDTO dto) {
        Optional<OSInterna> osInternaOptional = osInternaRepository.findById(dto.getId());
        if (osInternaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("OS Interna não encontrada.");
        }
        OSInterna existingOSInterna = osInternaOptional.get();
        BeanUtils.copyProperties(dto, existingOSInterna);
        existingOSInterna.setVeiculo(veiculoRepository.findById(dto.getVeiculo()).orElseThrow());
        if (!dto.getServicoIds().isEmpty()) {
            existingOSInterna.setServicos(dto.getServicoIds().stream()
                    .map(servicoRepository::findById)
                    .map(Optional::orElseThrow)
                    .collect(Collectors.toSet()));
        }
        osInternaRepository.save(existingOSInterna);
        return ResponseEntity.status(HttpStatus.OK).body(new responseOSInternaDTO(existingOSInterna));
    }

    public ResponseEntity<Object> deleteById(UUID id) {
        if (!osInternaRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("OS Interna não encontrada.");
        }
        osInternaRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    public ResponseEntity<List<responseOSInternaDTO>> findByVeiculoId(UUID veiculoId) {
        List<OSInterna> osInternaList = osInternaRepository.findAllByVeiculo(veiculoId);
        if (osInternaList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            List<responseOSInternaDTO> responseList = osInternaList.stream()
                    .map(responseOSInternaDTO::new)
                    .collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.OK).body(responseList);
        }
    }
}