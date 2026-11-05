package com.integracao_software.trabalho2.service;

import com.integracao_software.trabalho2.dto.AlunoDto;
import com.integracao_software.trabalho2.dto.AlunoResponseDto;
import com.integracao_software.trabalho2.model.AlunosEntity;
import com.integracao_software.trabalho2.repository.IAlunosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunosService {

    private final IAlunosRepository alunosRepository;

    public void cadastrarAluno(AlunoDto alunoDto){
        AlunosEntity aluno = alunosRepository.findByEmail(alunoDto.getEmail())
                .orElse(null);

        if(aluno != null){
            throw new RuntimeException("E-mail já cadastrado!");
        }

        aluno = new AlunosEntity();

        aluno.setNome(alunoDto.getNome());
        aluno.setEmail(alunoDto.getEmail());
        aluno.setIdade(alunoDto.getIdade());
        aluno.setTelefone(alunoDto.getTelefone());

        alunosRepository.save(aluno);
    }

    public Page<AlunoResponseDto> listarAlunos(Pageable pageable){
        return alunosRepository.findAll(pageable).map(this::converterEntityParaDto);
    }

    public AlunoResponseDto buscarAlunoId(Long id){
        AlunosEntity aluno = alunosRepository.findById(id)
                .orElse(null);

        if(aluno == null){
            throw new RuntimeException("Aluno não encontrado!");
        }

        return converterEntityParaDto(aluno);
    }

    public void atualizarAluno (Long id, AlunoDto alunoDto){
        AlunosEntity aluno = alunosRepository.findById(id)
                .orElse(null);

        if(aluno == null){
            throw new RuntimeException("Aluno não encontrado!");
        }

        aluno.setNome(alunoDto.getNome());
        aluno.setEmail(alunoDto.getEmail());
        aluno.setIdade(alunoDto.getIdade());
        aluno.setTelefone(alunoDto.getTelefone());

        alunosRepository.save(aluno);
    }

    public void deletarAluno(Long id){
        AlunosEntity aluno = alunosRepository.findById(id)
                .orElse(null);

        if(aluno == null){
            throw new RuntimeException("Aluno não encontrado!");
        }

        alunosRepository.delete(aluno);
    }

    public AlunoResponseDto converterEntityParaDto(AlunosEntity alunosEntity){
        return new AlunoResponseDto(
                alunosEntity.getId(),
                alunosEntity.getNome(),
                alunosEntity.getEmail(),
                alunosEntity.getIdade(),
                alunosEntity.getTelefone()
        );
    }
}
