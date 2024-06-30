package com.cargaexplosiva.api.repository;

import com.cargaexplosiva.api.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EstoqueRepository extends JpaRepository<Estoque, UUID>{
}
