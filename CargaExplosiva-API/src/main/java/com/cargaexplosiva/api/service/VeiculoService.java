package com.cargaexplosiva.api.service;

import com.cargaexplosiva.api.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService{

    final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }
}
