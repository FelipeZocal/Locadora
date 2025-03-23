package com.locadora.repositories;

import com.locadora.domains.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {
    Optional<PessoaFisica> findByEmail(String email);
    Optional<PessoaFisica> findById(Long id);
}
