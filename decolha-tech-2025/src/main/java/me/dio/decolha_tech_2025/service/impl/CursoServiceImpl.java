package me.dio.decolha_tech_2025.service.impl;

import lombok.RequiredArgsConstructor;
import me.dio.decolha_tech_2025.domain.model.Curso;
import me.dio.decolha_tech_2025.domain.repository.CursoRepository;
import me.dio.decolha_tech_2025.service.CursoService;
import org.springframework.stereotype.Service;
import me.dio.decolha_tech_2025.exception.ResourceNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    @Override
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Curso findById(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado com ID: " + id));
    }


    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso update(Long id, Curso curso) {
        Curso cursoExistente = findById(id);
        cursoExistente.setNome(curso.getNome());
        cursoExistente.setDescricao(curso.getDescricao());
        return cursoRepository.save(cursoExistente);
    }

    @Override
    public void delete(Long id) {
        Curso curso = findById(id);
        cursoRepository.delete(curso);
    }
}
