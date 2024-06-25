package com.cargaexplosiva.api.infra.security;

import com.cargaexplosiva.api.model.FuncionarioRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    final SecurityFilter securityFilter;
    final UserDetailsService userDetailsService;

    public SecurityConfiguration(SecurityFilter securityFilter, UserDetailsService userDetailsService) {
        this.securityFilter = securityFilter;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("auth/login", "register/administrador").permitAll()
                        .requestMatchers("register/gerente/frota",
                                "register/gerente/mecanico").hasAuthority(FuncionarioRole.ADMINISTRADOR.name())
                        .requestMatchers("register/mecanico").hasAnyAuthority(FuncionarioRole.GERENTE_MECANICO.name())
                        .requestMatchers("register/motorista").hasAnyAuthority(FuncionarioRole.GERENTE_FROTA.name())
                        .requestMatchers("bater-ponto").hasAnyAuthority(FuncionarioRole.MOTORISTA.name())
                        .requestMatchers(HttpMethod.GET).permitAll()
                        .anyRequest().permitAll()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return  authenticationConfiguration.getAuthenticationManager();
    }
}
