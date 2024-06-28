package com.cargaexplosiva.api.service;

import com.cargaexplosiva.api.dto.requestRegisterGerenteDTO;
import com.cargaexplosiva.api.dto.requestUpdateGerenteDTO;
import com.cargaexplosiva.api.model.FuncionarioRole;
import com.cargaexplosiva.api.model.Gerente;
import com.cargaexplosiva.api.repository.GerenteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class GerenteService{

    final GerenteRepository gerenteRepository;

    public GerenteService(GerenteRepository repositoryGerente) {
        this.gerenteRepository = repositoryGerente;
    }

    public void saveGerenteFrota(requestRegisterGerenteDTO gerentDTO){
        var gerente = new Gerente();
        BeanUtils.copyProperties(gerentDTO, gerente);
        gerente.setPassword(new BCryptPasswordEncoder().encode(gerentDTO.password()));
        gerente.setRole(FuncionarioRole.GERENTE_FROTA);
        gerenteRepository.save(gerente);
    }

    public void saveGerenteMecanico(requestRegisterGerenteDTO gerentDTO){
        var gerente = new Gerente();
        BeanUtils.copyProperties(gerentDTO, gerente);
        gerente.setPassword(new BCryptPasswordEncoder().encode(gerentDTO.password()));
        gerente.setRole(FuncionarioRole.GERENTE_MECANICO);
        gerenteRepository.save(gerente);
    }


    public ResponseEntity<Object> getById(UUID id) {
        Optional<Gerente> gerente = gerenteRepository.findById(id);
        return gerente.<ResponseEntity<Object>>
                        map(value -> ResponseEntity.status(HttpStatus.OK).body(value))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Gerente não encontrado."));
    }

    public ResponseEntity<Object> getByEmail(String email) {
        Optional<Gerente> gerente = gerenteRepository.findByEmail(email);
        return gerente.<ResponseEntity<Object>>
                        map(value -> ResponseEntity.status(HttpStatus.OK).body(value))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Gerente não encontrado."));
    }

    public ResponseEntity<Object> update(requestUpdateGerenteDTO gerenteDTO) {
        Optional<Gerente> gerenteOptional = gerenteRepository.findById(gerenteDTO.id_funcionario());
        if (gerenteOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Gerente não encontrado.");
        }
        var gerente = gerenteOptional.get();
        BeanUtils.copyProperties(gerenteDTO, gerente, "id", "password", "role", "pedidos");
        gerenteRepository.save(gerente);
        return ResponseEntity.status(HttpStatus.OK).body(gerente);
    }

    public ResponseEntity<Object> deleteById(UUID id) {
        if (!gerenteRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Gerente não encontrado.");
        }
        gerenteRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
