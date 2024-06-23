package com.cargaexplosiva.api.repository;

import com.cargaexplosiva.api.model.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, UUID> {

    Optional<Gerente> findByEmail(String email);

}
