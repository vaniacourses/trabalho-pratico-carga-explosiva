package com.cargaexplosiva.api.repository;

import com.cargaexplosiva.api.model.Oficina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OficinaRepository extends JpaRepository<Oficina, UUID> {
}
