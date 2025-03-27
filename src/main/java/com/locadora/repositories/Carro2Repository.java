package com.locadora.repositories;

import com.locadora.domains.Carro2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Carro2Repository extends JpaRepository<Carro2, Integer> {
    Optional<Carro2> findByCpfProprietario(String cpfProprietario);
}

