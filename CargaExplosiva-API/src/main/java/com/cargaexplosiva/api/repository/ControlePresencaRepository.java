package com.cargaexplosiva.api.repository;

import com.cargaexplosiva.api.model.ControlePresenca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ControlePresencaRepository extends JpaRepository<ControlePresenca, UUID> {
}
