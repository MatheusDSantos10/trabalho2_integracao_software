package com.integracao_software.trabalho2.controller;

import com.integracao_software.trabalho2.dto.MatriculaDto;
import com.integracao_software.trabalho2.dto.MatriculaResponseDto;
import com.integracao_software.trabalho2.service.MatriculasService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matriculas")
@RequiredArgsConstructor
public class MatriculasController {
    private final MatriculasService matriculasService;

    @PostMapping
    public ResponseEntity<MatriculaResponseDto> realizarMatricula(@Valid @RequestBody MatriculaDto matriculaDto) {
        return ResponseEntity.status(201).body(matriculasService.realizarMatricula(matriculaDto));
    }

    @GetMapping
    public ResponseEntity<Page<MatriculaResponseDto>> listarMatriculas(Pageable pageable) {
        return ResponseEntity.ok(matriculasService.listarMatriculas(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatriculaResponseDto> buscarMatriculaId(@PathVariable Long id) {
        return ResponseEntity.ok(matriculasService.buscarMatriculaId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatriculaResponseDto> atualizarMatricula(
            @PathVariable Long id, @Valid @RequestBody MatriculaDto matriculaDto) {
        return ResponseEntity.ok(matriculasService.atualizarMatricula(id, matriculaDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarMatricula(@PathVariable Long id) {
        matriculasService.cancelarMatricula(id);
        return ResponseEntity.noContent().build();
    }
}
