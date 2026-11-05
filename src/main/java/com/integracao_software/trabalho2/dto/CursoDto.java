package com.integracao_software.trabalho2.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CursoDto {

    @NotBlank(message = "Nome obrigatório")
    @Size(min = 5, message = "Mínimo 5 caracteres")
    private String nome;

    @NotNull(message = "Carga horária obrigatória")
    @Positive(message = "Carga horária deve ser maior que zero")
    private Integer cargaHoraria;

    @NotBlank(message = "Categoria obrigatória")
    private String categoria;

    @NotNull(message = "Situação (ativo) obrigatória")
    private Boolean ativo;
}
