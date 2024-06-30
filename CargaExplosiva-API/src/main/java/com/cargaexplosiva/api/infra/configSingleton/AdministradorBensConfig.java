package com.cargaexplosiva.api.infra.configSingleton;

import com.cargaexplosiva.api.model.Administrador;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AdministradorBensConfig {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Administrador administrador() {
        return new Administrador();
    }
}
