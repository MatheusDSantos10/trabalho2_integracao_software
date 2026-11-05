package com.integracao_software.trabalho2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CursoResponseDto {
    Long id;
    String nome;
    Integer cargaHoraria;
    String categoria;
    Boolean ativo;
}
