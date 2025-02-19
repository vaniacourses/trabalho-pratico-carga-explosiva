package com.cargaexplosiva.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.cargaexplosiva.api.dto.*;
import com.cargaexplosiva.api.model.Veiculo;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cargaexplosiva.api.model.FuncionarioRole;
import com.cargaexplosiva.api.model.Motorista;
import com.cargaexplosiva.api.repository.MotoristaRepository;

@Service
@Transactional
public class MotoristaService{

    final MotoristaRepository motoristaRepository;

    public MotoristaService(MotoristaRepository motoristaRepository) {
        this.motoristaRepository = motoristaRepository;
    }

    public void save(requestRegisterMotoristaDTO motoristaDTO){
        var motorista = new Motorista();
        BeanUtils.copyProperties(motoristaDTO, motorista);
        motorista.setPassword(new BCryptPasswordEncoder().encode(motoristaDTO.password()));
        motorista.setRole(FuncionarioRole.MOTORISTA);
        motorista.setAtivo(true);
        motoristaRepository.save(motorista);
    }

    public ResponseEntity<Object> getOne(String numCPF){
        Optional<Motorista> motorista = motoristaRepository.findByNumCPF(numCPF);
        return motorista.<ResponseEntity<Object>>map(
                value ->
                        ResponseEntity.status(HttpStatus.OK).body(new responseOneMotorista(value)))
                .orElseGet(() ->
                        ResponseEntity.status(HttpStatus.NOT_FOUND).body("Motorista não encontrado."));
    }

    public List<responseOneMotorista> getAll(){
         var motoristas =motoristaRepository.findAll();
         List<responseOneMotorista> response = new ArrayList<>();
         motoristas.forEach(e -> response.add(new responseOneMotorista(e)));

        return response;
    }
    public ResponseEntity<Object> update(requestUpdateMotoristaDTO motoristaDTO){
        Optional<Motorista> motorista = motoristaRepository.findByNumCPF(motoristaDTO.numCPF());
        if (motorista.isEmpty())  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Motorista não encontrado.");
        }
        var motoristaModel = motorista.get();
        BeanUtils.copyProperties(motoristaDTO, motoristaModel);
        return ResponseEntity.status(HttpStatus.OK).body(motoristaRepository.save(motoristaModel));
    }

    public Motorista find(String username){
        var motoristaOptional = motoristaRepository.findByEmail(username);
        return motoristaOptional.orElse(null);
    }

    public void delete(UUID id){
        motoristaRepository.deleteById(id);
    }

    public void delete(String numCPF){
        motoristaRepository.deleteByNumCPF(numCPF);
    }
}
