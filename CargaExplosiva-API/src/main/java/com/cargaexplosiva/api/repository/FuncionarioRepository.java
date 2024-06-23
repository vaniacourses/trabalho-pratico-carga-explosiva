package com.cargaexplosiva.api.repository;

import com.cargaexplosiva.api.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FuncionarioRepository extends JpaRepository<Funcionario, UUID> {

    Funcionario findByEmail(String email);

}
