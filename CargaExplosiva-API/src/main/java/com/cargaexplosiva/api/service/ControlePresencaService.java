package com.cargaexplosiva.api.service;

import com.cargaexplosiva.api.repository.ControlePresencaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ControlePresencaService {

    final ControlePresencaRepository controlePresencaRepository;

    public ControlePresencaService(ControlePresencaRepository controlePresencaRepository) {
        this.controlePresencaRepository = controlePresencaRepository;
    }
}
