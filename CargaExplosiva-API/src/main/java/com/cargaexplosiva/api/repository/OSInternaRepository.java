package com.cargaexplosiva.api.repository;

import com.cargaexplosiva.api.model.OSInterna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface OSInternaRepository extends JpaRepository<OSInterna, UUID> {
    @Query("SELECT o FROM os_interna o WHERE o.veiculo.id_veiculo = :veiculoId")
    List<OSInterna> findAllByVeiculo(UUID veiculoId);
}
