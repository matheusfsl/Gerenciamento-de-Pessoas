package com.pessoa.pessoa.repository;

import com.pessoa.pessoa.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, UUID> {
    Optional<PessoaModel> findByEmailContainingIgnoreCase(String email);
    Set<PessoaModel> findByIsActiveTrue();

    @Query("SELECT p FROM PessoaModel p " +
            "WHERE (:nome IS NULL OR p.name = :nome) " +
            "AND (:altura IS NULL OR p.altura = :altura) " +
            "AND (:peso IS NULL OR p.peso = :peso) " +
            "AND (:estado IS NULL OR p.estado = :estado)")
    Set<PessoaModel> findByFilter(
            @Param("nome") String nome,
            @Param("altura") Double altura,
            @Param("peso") Double peso,
            @Param("estado") String estado
    );
}
