package me.dio.decolha_tech_2025.service.impl;

import lombok.RequiredArgsConstructor;
import me.dio.decolha_tech_2025.domain.model.Disciplina;
import me.dio.decolha_tech_2025.domain.repository.DisciplinaRepository;
import me.dio.decolha_tech_2025.service.DisciplinaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DisciplinaServiceImpl implements DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    @Override
    public Disciplina save(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    @Override
    public Disciplina findById(Long id) {
        return disciplinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada!"));
    }

    @Override
    public List<Disciplina> findAll() {
        return disciplinaRepository.findAll();
    }

    @Override
    public Disciplina update(Long id, Disciplina disciplina) {
        Disciplina disciplinaExistente = findById(id);
        disciplinaExistente.setNome(disciplina.getNome());
        disciplinaExistente.setCodigo(disciplina.getCodigo());
        disciplinaExistente.setCurso(disciplina.getCurso());
        return disciplinaRepository.save(disciplinaExistente);
    }

    @Override
    public void delete(Long id) {
        Disciplina disciplina = findById(id);
        disciplinaRepository.delete(disciplina);
    }
}
