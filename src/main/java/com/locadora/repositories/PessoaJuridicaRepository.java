package com.locadora.repositories;

import com.locadora.domains.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {
    Optional<PessoaJuridica> findByEmail(String email);
    Optional<PessoaJuridica> findById (Long id);

}
