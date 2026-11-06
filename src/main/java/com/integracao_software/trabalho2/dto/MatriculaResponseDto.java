package com.integracao_software.trabalho2.dto;

import com.integracao_software.trabalho2.model.AlunosEntity;
import com.integracao_software.trabalho2.model.CursosEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MatriculaResponseDto {
    private Long id;
    private LocalDate dataMatricula;
    private Integer cargaHoraria;
    private String status;
    private CursosEntity curso;
    private AlunosEntity aluno;
}
