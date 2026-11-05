package com.integracao_software.trabalho2.repository;

import com.integracao_software.trabalho2.model.AlunosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAlunosRepository extends JpaRepository<AlunosEntity, Long> {
    Optional<AlunosEntity> findByEmail(String email);
}
