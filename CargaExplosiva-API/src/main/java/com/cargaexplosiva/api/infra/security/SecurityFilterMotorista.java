package com.cargaexplosiva.api.infra.security;

import com.cargaexplosiva.api.service.GerenteService;
import com.cargaexplosiva.api.service.MecanicoService;
import com.cargaexplosiva.api.service.MotoristaService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilterMotorista extends OncePerRequestFilter {

    final TokenService tokenService;

    final MotoristaService motoristaService;

    public SecurityFilterMotorista(TokenService tokenService, MotoristaService motoristaService) {
        this.tokenService = tokenService;
        this.motoristaService = motoristaService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        var token = this.recoverToken(request);
        if(token != null){
            var email = tokenService.validateToken(token);
            if(!email.isEmpty()){
                UserDetails user = motoristaService.find(email);
                var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");
        if(authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }
}
