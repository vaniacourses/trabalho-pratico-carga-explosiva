package com.cargaexplosiva.api.repository;

import com.cargaexplosiva.api.model.Mecanico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface MecanicoRepository extends JpaRepository<Mecanico, Integer> {

    UserDetails findAllByEmail(String email);
}
