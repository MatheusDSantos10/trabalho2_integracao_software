package com.integracao_software.trabalho2.service;

import com.integracao_software.trabalho2.dto.CursoDto;
import com.integracao_software.trabalho2.dto.CursoResponseDto;
import com.integracao_software.trabalho2.model.CursosEntity;
import com.integracao_software.trabalho2.repository.ICursosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursosService {

    private final ICursosRepository cursosRepository;

    public void cadastrarCurso(CursoDto cursoDto){
        CursosEntity curso = cursosRepository.findByNome(cursoDto.getNome())
                .orElse(null);

        if (curso != null){
            throw new RuntimeException("Curso já cadastrado com esse nome");
        }

        curso = new CursosEntity();

        curso.setNome(cursoDto.getNome());
        curso.setCargaHoraria(cursoDto.getCargaHoraria());
        curso.setCategoria(cursoDto.getCategoria());
        curso.setAtivo(cursoDto.getAtivo());

        cursosRepository.save(curso);
    }

    public Page<CursoResponseDto> listarCursos(Pageable pageable){
        return cursosRepository.findAll(pageable).map(this::converterEntityParaDto);
    }

    public CursoResponseDto buscarCursoId(Long id){
        CursosEntity curso = cursosRepository.findById(id).orElse(null);

        if(curso == null){
            throw new RuntimeException("Curso não encontrado");
        }

        return converterEntityParaDto(curso);
    }

    public void atualizarCurso (Long id, CursoDto cursoDto){
        CursosEntity curso = cursosRepository.findById(id)
                .orElse(null);

        if(curso == null){
            throw new RuntimeException("Curso não encontrado!");
        }

        curso.setNome(cursoDto.getNome());
        curso.setCargaHoraria(cursoDto.getCargaHoraria());
        curso.setCategoria(cursoDto.getCategoria());
        curso.setAtivo(cursoDto.getAtivo());

        cursosRepository.save(curso);
    }

    public void deletarCurso(Long id){
        CursosEntity curso = cursosRepository.findById(id)
                .orElse(null);

        if(curso == null){
            throw new RuntimeException("Curso não encontrado!");
        }

        cursosRepository.delete(curso);
    }

    public CursoResponseDto converterEntityParaDto(CursosEntity cursosEntity){
        return new CursoResponseDto(
                cursosEntity.getId(),
                cursosEntity.getNome(),
                cursosEntity.getCargaHoraria(),
                cursosEntity.getCategoria(),
                cursosEntity.getAtivo()
        );
    }
}
