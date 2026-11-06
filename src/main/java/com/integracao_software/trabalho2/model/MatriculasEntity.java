package com.integracao_software.trabalho2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "matriculas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatriculasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Data da matrícula é obrigatória")
    @Column(nullable = false)
    private LocalDate dataMatricula;

    @NotBlank(message = "Status da matrícula é obrigatório")
    @Column(nullable = false)
    private String status;

    @NotNull(message = "Curso é obrigatório")
    @ManyToOne(optional = false)
    @JoinColumn(name = "curso_id", nullable = false)
    private CursosEntity curso;

    @NotNull(message = "Aluno é obrigatório")
    @ManyToOne(optional = false)
    @JoinColumn(name = "aluno_id", nullable = false)
    private AlunosEntity aluno;
}
