package com.cargaexplosiva.api.repository;

import com.cargaexplosiva.api.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ServicoRepository extends JpaRepository<Servico, UUID> {
}
