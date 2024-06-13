package com.cargaexplosiva.api.infra.security;

import com.cargaexplosiva.api.infra.security.token.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class SecurityFilter extends OncePerRequestFilter {

        final TokenService tokenService;
        final UserRepository userRepository;

        @Override
        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            var token = this.recoverToken(request);
            if(token != null){
                var login = tokenService.validateToken(token);
                UserDetails user = userRepository.findByLogin(login);

                var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            filterChain.doFilter(request, response);
        }

        private String recoverToken(HttpServletRequest request){
            var authHeader = request.getHeader("Authorization");
            if(authHeader == null) return null;
            return authHeader.replace("Bearer ", "");
        }
    }

}
