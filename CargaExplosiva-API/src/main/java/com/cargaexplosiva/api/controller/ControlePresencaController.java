package com.cargaexplosiva.api.controller;

import com.cargaexplosiva.api.service.ControlePresencaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;


@RestController
@RequestMapping("bater-ponto")
public class ControlePresencaController {

    private final ControlePresencaService controlePresencaService;

    public ControlePresencaController(ControlePresencaService controlePresencaService) {
        this.controlePresencaService = controlePresencaService;
    }

    @PostMapping("/{ativo}")
    public ResponseEntity<Object> baterPonto(@PathVariable(value = "ativo") boolean isAtivo){
        try{
            UserDetails auth =
                    (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            controlePresencaService.baterPonto(auth,
                    new Timestamp(System.currentTimeMillis()), isAtivo);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
