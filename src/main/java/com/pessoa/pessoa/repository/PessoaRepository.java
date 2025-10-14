package com.pessoa.pessoa.repository;

import com.pessoa.pessoa.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, UUID> {
    Optional<PessoaModel> findByEmailContainingIgnoreCase(String email);
    Set<PessoaModel> findByIsActiveTrue();
}
