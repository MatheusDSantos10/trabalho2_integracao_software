package com.integracao_software.trabalho2.service;

import com.integracao_software.trabalho2.dto.MatriculaDto;
import com.integracao_software.trabalho2.dto.MatriculaResponseDto;
import com.integracao_software.trabalho2.model.AlunosEntity;
import com.integracao_software.trabalho2.model.CursosEntity;
import com.integracao_software.trabalho2.model.MatriculasEntity;
import com.integracao_software.trabalho2.repository.IAlunosRepository;
import com.integracao_software.trabalho2.repository.ICursosRepository;
import com.integracao_software.trabalho2.repository.IMatriculasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatriculasService {
    private final IMatriculasRepository matriculasRepository;
    private final ICursosRepository cursosRepository;
    private final IAlunosRepository alunosRepository;

    public MatriculaResponseDto realizarMatricula(MatriculaDto dto) {
        MatriculasEntity matricula = new MatriculasEntity();
        preencherMatricula(matricula, dto);
        return converterEntityParaDto(matriculasRepository.save(matricula));
    }

    public Page<MatriculaResponseDto> listarMatriculas(Pageable pageable) {
        return matriculasRepository.findAll(pageable).map(this::converterEntityParaDto);
    }

    public MatriculaResponseDto buscarMatriculaId(Long id) {
        return converterEntityParaDto(buscarEntidade(id));
    }

    public MatriculaResponseDto atualizarMatricula(Long id, MatriculaDto dto) {
        MatriculasEntity matricula = buscarEntidade(id);
        preencherMatricula(matricula, dto);
        return converterEntityParaDto(matriculasRepository.save(matricula));
    }

    public void cancelarMatricula(Long id) {
        matriculasRepository.delete(buscarEntidade(id));
    }

    private void preencherMatricula(MatriculasEntity matricula, MatriculaDto dto) {
        CursosEntity curso = cursosRepository.findById(dto.getCursoId())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
        AlunosEntity aluno = alunosRepository.findById(dto.getAlunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        if (!Boolean.TRUE.equals(curso.getAtivo())) {
            throw new RuntimeException("Não é possível realizar matrícula em curso inativo");
        }
        if (aluno.getIdade() == null || aluno.getIdade() < 16) {
            throw new RuntimeException("O aluno deve ter pelo menos 16 anos para se matricular");
        }

        matricula.setDataMatricula(dto.getDataMatricula());
        matricula.setStatus(dto.getStatus());
        matricula.setCurso(curso);
        matricula.setAluno(aluno);
    }

    private MatriculasEntity buscarEntidade(Long id) {
        return matriculasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matrícula não encontrada"));
    }

    private MatriculaResponseDto converterEntityParaDto(MatriculasEntity matricula) {
        return new MatriculaResponseDto(
                matricula.getId(),
                matricula.getDataMatricula(),
                matricula.getCurso().getCargaHoraria(),
                matricula.getStatus(),
                matricula.getCurso(),
                matricula.getAluno()
        );
    }
}
