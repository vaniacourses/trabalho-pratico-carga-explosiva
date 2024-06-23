package com.cargaexplosiva.api.repository;

import com.cargaexplosiva.api.model.AtribuicaoVeiculoMotorista;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Registered
public interface AtribuicaoVeiculoMotoristaRepository extends JpaRepository<AtribuicaoVeiculoMotorista, UUID> {
}
