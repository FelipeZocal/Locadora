package com.locadora.repositories;

import com.locadora.domains.Locadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocadoraRepository extends JpaRepository<Locadora,Integer> {
    Optional<Locadora> findByCnpj(String cnpj);
}
