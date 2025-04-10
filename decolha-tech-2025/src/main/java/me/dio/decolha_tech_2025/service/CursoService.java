package me.dio.decolha_tech_2025.service;

import me.dio.decolha_tech_2025.domain.model.Curso;

import java.util.List;

public interface CursoService {

    Curso save(Curso curso);
    Curso findById(Long id);
    List<Curso> findAll();
    Curso update(Long id, Curso curso);
    void delete(Long id);
}
