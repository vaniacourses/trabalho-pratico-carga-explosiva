package com.cargaexplosiva.api.repository;

import com.cargaexplosiva.api.model.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Long> {

    UserDetails findAllByEmail(String email);
}
