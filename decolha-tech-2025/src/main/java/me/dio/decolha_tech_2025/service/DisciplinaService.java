package me.dio.decolha_tech_2025.service;

import me.dio.decolha_tech_2025.domain.model.Disciplina;

import java.util.List;

public interface DisciplinaService {

    Disciplina save(Disciplina disciplina);
    Disciplina findById(Long id);
    List<Disciplina> findAll();
    Disciplina update(Long id, Disciplina disciplina);
    void delete(Long id);
}
