package com.cargaexplosiva.api.service;

import com.cargaexplosiva.api.dto.AddVeiculoDTO;
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

    public Object save(AddVeiculoDTO veiculoDTO){
        var veiculo = new Veiculo();
        BeanUtils.copyProperties(veiculoDTO, veiculo);
        return veiculoRepository.save(veiculo);
    }
}
