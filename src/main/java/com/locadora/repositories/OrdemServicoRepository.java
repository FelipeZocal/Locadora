package com.locadora.repositories;

import com.locadora.domains.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, UUID> {
    Optional<OrdemServico> findById (UUID id);
    Optional<OrdemServico> findByTituloOS (String tituloOS);
}
