package com.integracao_software.trabalho2.repository;


import com.integracao_software.trabalho2.model.MatriculasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMatriculasRepository extends JpaRepository<MatriculasEntity, Long> {
}
