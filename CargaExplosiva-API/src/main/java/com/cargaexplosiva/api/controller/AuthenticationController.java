package com.cargaexplosiva.api.controller;

import com.cargaexplosiva.api.dto.RequestLoginDTO;
import com.cargaexplosiva.api.infra.security.token.TokenService;
import com.cargaexplosiva.api.infra.security.userdetails.JWTUserDetailsService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController{

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final JWTUserDetailsService userDetailsService;

    public AuthenticationController(AuthenticationManager authenticationManager,
                                    TokenService tokenService,
                                    JWTUserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.userDetailsService = userDetailsService;
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch (BadCredentialsException e) {
            throw new BadCredentialsException("Email ou senha incorreta.");
        }
    }

    @PostMapping
    public ResponseEntity<Object> login(@RequestBody @Valid RequestLoginDTO request) throws Exception{
        try {
            authenticate(request.email(), request.password());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email" +
                    " e/ou senha invalido(s).");
        }
        final UserDetails userDetails =
                userDetailsService.loadUserByUsername(request.email());
        final String token = tokenService.generateToken(userDetails);
        return ResponseEntity.status(HttpStatus.OK).body(token);
    }
}
