package com.cargaexplosiva.api.controller;

import com.cargaexplosiva.api.model.*;
import com.cargaexplosiva.api.service.AtribuicaoVeiculoMotoristaService;
import com.cargaexplosiva.api.service.GerenteService;
import com.cargaexplosiva.api.service.MotoristaService;
import com.cargaexplosiva.api.service.VeiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("gerente")
public class GerenteController{

    private final GerenteService gerenteService;

    public GerenteController(GerenteService gerenteService) {
        this.gerenteService = gerenteService;
    }

}
