package com.cargaexplosiva.api.service;

import com.cargaexplosiva.api.dto.requestSaveVeiculoDTO;
import com.cargaexplosiva.api.dto.responseSaveVeiculoDTO;
import com.cargaexplosiva.api.model.Veiculo;
import com.cargaexplosiva.api.repository.VeiculoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
