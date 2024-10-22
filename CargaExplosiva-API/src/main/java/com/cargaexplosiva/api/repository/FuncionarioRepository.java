package com.cargaexplosiva.api.repository;

import com.cargaexplosiva.api.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, UUID> {

    Funcionario findByEmail(String email);

}
