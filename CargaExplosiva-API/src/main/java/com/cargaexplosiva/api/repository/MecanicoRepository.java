package com.cargaexplosiva.api.repository;

import com.cargaexplosiva.api.model.Mecanico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MecanicoRepository extends JpaRepository<Mecanico, UUID> {

    Optional<Mecanico> findByEmail(String email);

}
