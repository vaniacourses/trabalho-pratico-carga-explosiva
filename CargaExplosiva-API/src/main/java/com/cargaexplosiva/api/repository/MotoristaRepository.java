package com.cargaexplosiva.api.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cargaexplosiva.api.model.Motorista;


@Repository
public interface MotoristaRepository extends JpaRepository<Motorista, UUID> {

    Optional<Motorista> findByEmail(String email);
    
    Optional<Motorista> findByNumCPF(String numCPF);

    void deleteByNumCPF(String numCPF);

}
