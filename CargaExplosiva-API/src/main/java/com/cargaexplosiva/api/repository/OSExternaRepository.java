package com.cargaexplosiva.api.repository;

import com.cargaexplosiva.api.model.OSExterna;
import com.cargaexplosiva.api.model.OSInterna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface OSExternaRepository extends JpaRepository<OSExterna, UUID> {
    @Query("SELECT o FROM os_externa o WHERE o.veiculo.id_veiculo = :veiculoId")
    List<OSExterna> findAllByVeiculo(UUID veiculoId);
}

