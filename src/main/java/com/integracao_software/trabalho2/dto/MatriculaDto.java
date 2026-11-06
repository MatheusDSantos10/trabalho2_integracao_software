package com.integracao_software.trabalho2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaDto {
    @NotNull(message = "Data da matrícula é obrigatória")
    private LocalDate dataMatricula;

    @NotBlank(message = "Status da matrícula é obrigatório")
    private String status;

    @NotNull(message = "ID do curso é obrigatório")
    private Long cursoId;

    @NotNull(message = "ID do aluno é obrigatório")
    private Long alunoId;
}
