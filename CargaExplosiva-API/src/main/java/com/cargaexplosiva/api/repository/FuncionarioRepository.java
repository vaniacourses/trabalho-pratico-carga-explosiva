package com.cargaexplosiva.api.repository;

import com.cargaexplosiva.api.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Funcionario findByEmail(String email);

}
