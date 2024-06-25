package com.cargaexplosiva.api.repository;

import com.cargaexplosiva.api.model.ControlePresenca;
import com.cargaexplosiva.api.model.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ControlePresencaRepository extends JpaRepository<ControlePresenca, UUID> {

    Optional<ControlePresenca> findByMotoristaAndSaidaIsNull(Motorista motorista);

}
