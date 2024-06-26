package com.cargaexplosiva.api.repository;

import com.cargaexplosiva.api.model.ItemDoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemDoEstoqueRepository extends JpaRepository<ItemDoEstoque, UUID> {
}
