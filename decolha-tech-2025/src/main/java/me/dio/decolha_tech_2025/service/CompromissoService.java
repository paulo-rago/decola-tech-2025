package me.dio.decolha_tech_2025.service;

import me.dio.decolha_tech_2025.domain.model.Compromisso;

import java.util.List;

public interface CompromissoService {

    Compromisso save(Compromisso compromisso);
    Compromisso findById(Long id);
    List<Compromisso> findAll();
    Compromisso update(Long id, Compromisso compromisso);
    void delete(Long id);

    List<Compromisso> findByUsuarioId(Long usuarioId);
}
