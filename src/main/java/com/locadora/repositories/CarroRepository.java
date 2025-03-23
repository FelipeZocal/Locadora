package com.locadora.repositories;

import com.locadora.domains.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarroRepository extends JpaRepository<Carro, Integer> {
    Optional<Carro> findByPlaca(String placa);
}
