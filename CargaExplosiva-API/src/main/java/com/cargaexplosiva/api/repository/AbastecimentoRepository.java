package com.cargaexplosiva.api.repository;

import com.cargaexplosiva.api.model.Abastecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AbastecimentoRepository extends JpaRepository<Abastecimento, UUID> {
}
