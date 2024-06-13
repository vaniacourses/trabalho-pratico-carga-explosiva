package com.cargaexplosiva.api.repository;

import com.cargaexplosiva.api.model.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;


@Repository
public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

    UserDetails findByEmail(String email);

}
