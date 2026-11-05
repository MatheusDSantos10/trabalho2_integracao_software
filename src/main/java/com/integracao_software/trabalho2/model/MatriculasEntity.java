package com.integracao_software.trabalho2.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "matriculas")
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@Builder
public class MatriculasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate dataMatricula;

    @Column(nullable = false)
    private Integer cargaHoraria;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "curso")
    private CursosEntity curso;

    @ManyToOne
    @JoinColumn(name = "aluno")
    private AlunosEntity aluno;
}
