package com.cargaexplosiva.api.infra.security;

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

    final CompositeUserDetailsService compositeUserDetailsService;

    final SecurityFilterMotorista securityFilterMotorista;
    final SecurityFilterMecanico securityFilterMecanico;
    final SecurityFilterGerente securityFilterGerente;

    public SecurityConfiguration(CompositeUserDetailsService compositeUserDetailsService, SecurityFilterMotorista securityFilterMotorista, SecurityFilterMecanico securityFilterMecanico, SecurityFilterGerente securityFilterGerente) {
        this.compositeUserDetailsService = compositeUserDetailsService;
        this.securityFilterMotorista = securityFilterMotorista;
        this.securityFilterMecanico = securityFilterMecanico;
        this.securityFilterGerente = securityFilterGerente;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.GET).permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilterMotorista, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(securityFilterMecanico, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(securityFilterGerente, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return  authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return compositeUserDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
