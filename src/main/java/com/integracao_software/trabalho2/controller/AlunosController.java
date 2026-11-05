package com.integracao_software.trabalho2.controller;

import com.integracao_software.trabalho2.dto.AlunoDto;
import com.integracao_software.trabalho2.dto.AlunoResponseDto;
import com.integracao_software.trabalho2.service.AlunosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunosController {

    private final AlunosService alunosService;

    @PostMapping
    public ResponseEntity<String> cadastrarAluno(@Valid @RequestBody AlunoDto alunoDto){
        alunosService.cadastrarAluno(alunoDto);
        return ResponseEntity.created(null).body("Aluno cadastrado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<Page<AlunoResponseDto>> listarAlunos(Pageable pageable){
        return ResponseEntity.ok(alunosService.listarAlunos(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponseDto> buscarAlunoId(@PathVariable Long id){
        return ResponseEntity.ok(alunosService.buscarAlunoId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarAluno(@PathVariable Long id, @Valid @RequestBody AlunoDto alunoDto){
        alunosService.atualizarAluno(id, alunoDto);
        return ResponseEntity.ok("Aluno atualizado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarAluno(@PathVariable Long id){
        alunosService.deletarAluno(id);
        return ResponseEntity.noContent().build();
    }
}
