package com.cargaexplosiva.api.service;

import com.cargaexplosiva.api.dto.requestSaveVeiculoDTO;
import com.cargaexplosiva.api.dto.requestUpdateVeiculoDTO;
import com.cargaexplosiva.api.dto.responseOneVeiculo;
import com.cargaexplosiva.api.dto.responseSaveVeiculoDTO;
import com.cargaexplosiva.api.model.Veiculo;
import com.cargaexplosiva.api.repository.VeiculoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class VeiculoService{

    final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public Object save(requestSaveVeiculoDTO veiculoDTO){
        var veiculo = new Veiculo();
        BeanUtils.copyProperties(veiculoDTO, veiculo);
        veiculo = veiculoRepository.save(veiculo);
        return new responseSaveVeiculoDTO(veiculo);
    }

    public ResponseEntity<Object> getOne(UUID id){
        try {
            Optional<Veiculo> veiculo = veiculoRepository.findById(id);
            if(veiculo.isPresent()){
                var motorista = veiculo.get().getMotoristaAtual();
                return motorista.<ResponseEntity<Object>>map(
                        value ->
                                ResponseEntity.status(HttpStatus.OK)
                                        .body(new responseOneVeiculo(veiculo.get(), value)))
                        .orElseGet(() ->
                                ResponseEntity.status(HttpStatus.OK)
                                        .body(new responseOneVeiculo(veiculo.get())));
            }return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veiculo " +
                    "Não Encontrado.");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro " +
                    "ao buscar veiculo.");
        }
    }

    public List<responseOneVeiculo> getAll(){
        var veiculos = veiculoRepository.findAll();
        List<responseOneVeiculo> response = new ArrayList<>();
        veiculos.forEach(e -> {
            var motorista = e.getMotoristaAtual();
            if(motorista.isPresent()){
                response.add(new responseOneVeiculo(e, motorista.get()));
            }else response.add(new responseOneVeiculo(e));
        });
        return response;
    }

    public ResponseEntity<Object> update(requestUpdateVeiculoDTO veiculoDTO){
        Optional<Veiculo> veiculoOptional =
                veiculoRepository.findById(veiculoDTO.id_veiculo());
        if(veiculoOptional.isPresent()){
            var veiculo = veiculoOptional.get();
            BeanUtils.copyProperties(veiculoDTO, veiculo);
            var motoristaOptional = veiculo.getMotoristaAtual();
            return motoristaOptional.<ResponseEntity<Object>>map(
                    motorista ->
                            ResponseEntity.status(HttpStatus.OK)
                                    .body(new responseOneVeiculo(veiculo, motorista)))
                    .orElseGet(() ->
                            ResponseEntity.status(HttpStatus.OK)
                                    .body(new responseOneVeiculo(veiculo)));
        }else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                "Veiculo não encontrado.");
    }

    public void delete(UUID idVeiculo){
        veiculoRepository.deleteById(idVeiculo);
    }
}
