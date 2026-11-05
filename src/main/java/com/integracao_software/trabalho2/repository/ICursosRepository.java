package com.integracao_software.trabalho2.repository;

import com.integracao_software.trabalho2.model.CursosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICursosRepository extends JpaRepository<CursosEntity, Long> {
    Optional<CursosEntity> findByNome(String nome);
}
