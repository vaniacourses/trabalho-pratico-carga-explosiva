package com.cargaexplosiva.api.controller;

import com.cargaexplosiva.api.service.ControlePresencaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bater-ponto")
public class ControlePresencaController {

    private final ControlePresencaService controlePresencaService;

    public ControlePresencaController(ControlePresencaService controlePresencaService) {
        this.controlePresencaService = controlePresencaService;
    }
}
