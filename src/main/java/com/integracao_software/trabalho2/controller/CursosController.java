package com.integracao_software.trabalho2.controller;

import com.integracao_software.trabalho2.dto.CursoDto;
import com.integracao_software.trabalho2.dto.CursoResponseDto;
import com.integracao_software.trabalho2.service.CursosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursosController {

    private final CursosService cursosService;

    @PostMapping
    public ResponseEntity<String> cadastrarCurso(@Valid @RequestBody CursoDto cursoDto){
        cursosService.cadastrarCurso(cursoDto);
        return ResponseEntity.created(null).body("Curso cadastrado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<Page<CursoResponseDto>> listarCursos(Pageable pageable){
        return ResponseEntity.ok(cursosService.listarCursos(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponseDto> buscarCursoId(@PathVariable Long id){
        return ResponseEntity.ok(cursosService.buscarCursoId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarCurso(@PathVariable Long id, @Valid @RequestBody CursoDto cursoDto){
        cursosService.atualizarCurso(id, cursoDto);
        return ResponseEntity.ok("Curso atualizado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCurso(@PathVariable Long id){
        cursosService.deletarCurso(id);
        return ResponseEntity.noContent().build();
    }
}
