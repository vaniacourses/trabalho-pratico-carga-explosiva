package com.cargaexplosiva.api.controller;

import com.cargaexplosiva.api.dto.requestSaveOSInternaDTO;
import com.cargaexplosiva.api.dto.requestSaveOSExternaDTO;
import com.cargaexplosiva.api.dto.requestUpdateOSInternaDTO;
import com.cargaexplosiva.api.dto.requestUpdateOSExternaDTO;
import com.cargaexplosiva.api.dto.responseOSInternaDTO;
import com.cargaexplosiva.api.dto.responseOSExternaDTO;
import com.cargaexplosiva.api.model.OSExterna;
import com.cargaexplosiva.api.model.OSInterna;
import com.cargaexplosiva.api.repository.OSInternaRepository;
import com.cargaexplosiva.api.repository.OSExternaRepository;
import com.cargaexplosiva.api.service.OSInternaService;
import com.cargaexplosiva.api.service.OSExternaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.zaxxer.hikari.util.PropertyElf.copyProperties;

@RestController
@RequestMapping("ordemservico")
public class FacadeOSController {

    @Autowired
    private OSInternaService osInternaService;

    @Autowired
    private OSExternaService osExternaService;

    @Autowired
    private OSInternaRepository osInternaRepository;

    @Autowired
    private OSExternaRepository osExternaRepository;
    @PostMapping("/interna")
    public ResponseEntity<Object> criarOSInterna(@RequestBody requestSaveOSInternaDTO dto) {
        responseOSInternaDTO response = osInternaService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/externa")
    public ResponseEntity<Object> criarOSExterna(@RequestBody requestSaveOSExternaDTO dto) {
        responseOSExternaDTO response = osExternaService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{tipo}/{id}")
    public ResponseEntity<Object> obterOS(@PathVariable String tipo, @PathVariable UUID id) {
        if ("interna".equalsIgnoreCase(tipo)) {
            return osInternaRepository.findById(id)
                    .<ResponseEntity<Object>>map(osInterna -> ResponseEntity.ok(new responseOSInternaDTO(osInterna)))
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("OS Interna não encontrada."));
        } else if ("externa".equalsIgnoreCase(tipo)) {
            return osExternaRepository.findById(id)
                    .<ResponseEntity<Object>>map(osExterna -> ResponseEntity.ok(new responseOSExternaDTO(osExterna)))
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("OS Externa não encontrada."));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tipo de OS inválido");
        }
    }

    @GetMapping("/{tipo}")
    public ResponseEntity<List<?>> obterTodasOS(@PathVariable String tipo) {
        if ("interna".equalsIgnoreCase(tipo)) {
            return ResponseEntity.status(HttpStatus.OK).body(osInternaService.findAll());
        } else if ("externa".equalsIgnoreCase(tipo)) {
            return ResponseEntity.status(HttpStatus.OK).body(osExternaService.findAll());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


    @PutMapping("/interna")
    public ResponseEntity<Object> atualizarOSInterna(@RequestBody requestUpdateOSInternaDTO dto) {
        return osInternaService.update(dto);
    }

    @PutMapping("/externa")
    public ResponseEntity<Object> atualizarOSExterna(@RequestBody requestUpdateOSExternaDTO dto) {
        return osExternaService.update(dto);
    }


    @DeleteMapping("/{tipo}/{id}")
    public ResponseEntity<Object> deletarOS(@PathVariable String tipo, @PathVariable UUID id) {
        if ("interna".equalsIgnoreCase(tipo)) {
            return osInternaService.deleteById(id);
        } else if ("externa".equalsIgnoreCase(tipo)) {
            return osExternaService.deleteById(id);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tipo de OS inválido");
        }
    }

    @GetMapping("/veiculo/interna/{veiculoId}")
    public ResponseEntity<List<responseOSInternaDTO>> obterOSInternaPorVeiculo(@PathVariable UUID veiculoId) {
        return osInternaService.findByVeiculoId(veiculoId);
    }

    @GetMapping("/veiculo/externa/{veiculoId}")
    public ResponseEntity<List<responseOSExternaDTO>> obterOSExternaPorVeiculo(@PathVariable UUID veiculoId) {
        return osExternaService.findByVeiculoId(veiculoId);
    }



    @PutMapping("/concluir/interna/{id}")
    public ResponseEntity<Object> concluirOSInterna(@PathVariable UUID id) {
        Optional<OSInterna> optionalOsInterna = osInternaRepository.findById(id);
        if (optionalOsInterna.isPresent()) {
            OSInterna osInterna = optionalOsInterna.get();
            requestUpdateOSInternaDTO updateDTO = new requestUpdateOSInternaDTO(
                    osInterna.getId_ordem(),
                    osInterna.getCodigo(),
                    osInterna.getDataInicio(),
                    osInterna.getDataFim(),
                    osInterna.getTipo(),
                    osInterna.getValor(),
                    osInterna.getDescricao(),
                    osInterna.getStatus(),
                    osInterna.getKm(),
                    osInterna.getVeiculo().getId_veiculo(),
                    osInterna.getServicos().stream().map(servico -> servico.getId_servico()).collect(Collectors.toSet())
            );
            updateDTO.setStatus('C');
            return osInternaService.update(updateDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("OS Interna não encontrada.");
    }

    @PutMapping("/concluir/externa/{id}")
    public ResponseEntity<Object> concluirOSExterna(@PathVariable UUID id) {
        Optional<OSExterna> optionalOsExterna = osExternaRepository.findById(id);
        if (optionalOsExterna.isPresent()) {
            OSExterna osExterna = optionalOsExterna.get();
            requestUpdateOSExternaDTO updateDTO = new requestUpdateOSExternaDTO(
                    osExterna.getId_ordem(),
                    osExterna.getCodigo(),
                    osExterna.getDataInicio(),
                    osExterna.getDataFim(),
                    osExterna.getTipo(),
                    osExterna.getValor(),
                    osExterna.getDescricao(),
                    osExterna.getStatus(),
                    osExterna.getKm(),
                    osExterna.getVeiculo().getId_veiculo(),
                    osExterna.getOficina().getId_oficina(),
                    osExterna.getServicos().stream().map(servico -> servico.getId_servico()).collect(Collectors.toSet())
            );
            updateDTO.setStatus('C');
            return osExternaService.update(updateDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("OS Externa não encontrada.");
    }
}