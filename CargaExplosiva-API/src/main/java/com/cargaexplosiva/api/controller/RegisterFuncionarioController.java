package com.cargaexplosiva.api.controller;

import com.cargaexplosiva.api.dto.requestRegisterGerenteDTO;
import com.cargaexplosiva.api.dto.requestRegisterMecanicoDTO;
import com.cargaexplosiva.api.dto.requestRegisterMotoristaDTO;
import com.cargaexplosiva.api.service.AdministradorService;
import com.cargaexplosiva.api.service.GerenteService;
import com.cargaexplosiva.api.service.MecanicoService;
import com.cargaexplosiva.api.service.MotoristaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("register")
public class RegisterFuncionarioController {

    private final GerenteService gerenteService;
    private final MecanicoService mecanicoService;
    private final MotoristaService motoristaService;
    private final AdministradorService administradorService;

    public RegisterFuncionarioController(GerenteService gerenteService,
                                         MecanicoService mecanicoService,
                                         MotoristaService motoristaService,
                                         AdministradorService administradorService) {
        this.gerenteService = gerenteService;
        this.mecanicoService = mecanicoService;
        this.motoristaService = motoristaService;
        this.administradorService = administradorService;
    }

    @PostMapping("/gerente/frota")
    ResponseEntity<Object> registerGerenteFrota(@RequestBody @Valid requestRegisterGerenteDTO gerentDTO){
        try {
            gerenteService.saveGerenteFrota(gerentDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro " +
                    "ao cadastrar gerente de frota.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Gerente de" +
                " Frota cadastrado com sucesso.");
    }

    @PostMapping("/gerente/mecanico")
    ResponseEntity<Object> registerGerenteMecanico(@RequestBody @Valid requestRegisterGerenteDTO gerentDTO){
        try {
            gerenteService.saveGerenteMecanico(gerentDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro " +
                    "ao cadastrar gerente mecanico.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Gerente " +
                "mecanico cadastrado com sucesso.");
    }

    @PostMapping("/motorista")
    ResponseEntity<Object> registerMotorista(@RequestBody @Valid requestRegisterMotoristaDTO motoristaDTO){
        try {
            motoristaService.save(motoristaDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro " +
                    "ao cadastrar motorista.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Motorista " +
                "cadastrado com sucesso.");
    }

    @PostMapping("/mecanico")
    ResponseEntity<Object> registerMecanico(@RequestBody @Valid requestRegisterMecanicoDTO mecanicoDTO){
        try {
            mecanicoService.save(mecanicoDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro " +
                    "ao cadastrar mecanico.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Mecanico " +
                "cadastrado com sucesso.");
    }

    @PostMapping("/administrador")
    ResponseEntity<Object> registerAdministrador(){
        try {
            administradorService.save();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro " +
                    "ao cadastrar administrador.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(
                "Administrador cadastrado com sucesso.");
    }

}
