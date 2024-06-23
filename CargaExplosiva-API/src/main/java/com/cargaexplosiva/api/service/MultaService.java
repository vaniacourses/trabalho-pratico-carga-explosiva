package com.cargaexplosiva.api.service;

import com.cargaexplosiva.api.repository.MultaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MultaService {

    final MultaRepository multaRepository;

    public MultaService(MultaRepository multaRepository) {
        this.multaRepository = multaRepository;
    }
}
