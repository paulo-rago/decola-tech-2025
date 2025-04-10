package me.dio.decolha_tech_2025.service;

import me.dio.decolha_tech_2025.domain.model.Lembrete;

import java.util.List;

public interface LembreteService {

    Lembrete save(Lembrete lembrete);
    Lembrete findById(Long id);
    List<Lembrete> findAll();
    Lembrete update(Long id, Lembrete lembrete);
    void delete(Long id);
}
