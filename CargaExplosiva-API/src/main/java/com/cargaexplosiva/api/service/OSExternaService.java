package com.cargaexplosiva.api.service;

import com.cargaexplosiva.api.dto.requestSaveOSExternaDTO;
import com.cargaexplosiva.api.dto.requestUpdateOSExternaDTO;
import com.cargaexplosiva.api.dto.responseOSExternaDTO;
import com.cargaexplosiva.api.model.OSExterna;
import com.cargaexplosiva.api.repository.OSExternaRepository;
import com.cargaexplosiva.api.repository.OficinaRepository;
import com.cargaexplosiva.api.repository.ServicoRepository;
import com.cargaexplosiva.api.repository.VeiculoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class OSExternaService {

    @Autowired
    private OSExternaRepository osExternaRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private OficinaRepository oficinaRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    public responseOSExternaDTO save(requestSaveOSExternaDTO dto) {
        var osExterna = new OSExterna();
        BeanUtils.copyProperties(dto, osExterna);
        osExterna.setVeiculo(veiculoRepository.findById(dto.veiculoId()).orElseThrow());
        osExterna.setOficina(oficinaRepository.findById(dto.oficinaId()).orElseThrow());
        if (dto.servicoIds() != null) {
            osExterna.setServicos(dto.servicoIds().stream()
                    .map(id -> servicoRepository.findById(id).orElseThrow())
                    .collect(Collectors.toSet()));
        }
        osExterna = osExternaRepository.save(osExterna);
        return new responseOSExternaDTO(osExterna);
    }

    public List<responseOSExternaDTO> findAll() {
        return osExternaRepository.findAll().stream()
                .map(responseOSExternaDTO::new)
                .collect(Collectors.toList());
    }

    public ResponseEntity<Object> findById(UUID id) {
        Optional<OSExterna> osExterna = osExternaRepository.findById(id);
        return osExterna.<ResponseEntity<Object>>
        map(value -> ResponseEntity.status(HttpStatus.OK).body(new responseOSExternaDTO(value)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("OS Externa não encontrada."));
    }

    public ResponseEntity<Object> update(requestUpdateOSExternaDTO dto) {
        Optional<OSExterna> osExternaOptional = osExternaRepository.findById(dto.getId());
        if (osExternaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("OS Externa não encontrada.");
        }
        OSExterna existingOSExterna = osExternaOptional.get();
        BeanUtils.copyProperties(dto, existingOSExterna);
        existingOSExterna.setVeiculo(veiculoRepository.findById(dto.getVeiculoId()).orElseThrow());
        existingOSExterna.setOficina(oficinaRepository.findById(dto.getOficinaId()).orElseThrow());
        if (!dto.getServicoIds().isEmpty()) {
            existingOSExterna.setServicos(dto.getServicoIds().stream()
                    .map(servicoRepository::findById)
                    .map(Optional::orElseThrow)
                    .collect(Collectors.toSet()));
        }
        osExternaRepository.save(existingOSExterna);
        return ResponseEntity.status(HttpStatus.OK).body(new responseOSExternaDTO(existingOSExterna));
    }

    public ResponseEntity<Object> deleteById(UUID id) {
        if (!osExternaRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("OS Externa não encontrada.");
        }
        osExternaRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    public ResponseEntity<List<responseOSExternaDTO>> findByVeiculoId(UUID veiculoId) {
        List<OSExterna> osExternaList = osExternaRepository.findAllByVeiculo(veiculoId);
        if (osExternaList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            List<responseOSExternaDTO> responseList = osExternaList.stream()
                    .map(responseOSExternaDTO::new)
                    .collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.OK).body(responseList);
        }
    }

}