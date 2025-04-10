package me.dio.decolha_tech_2025.service.impl;

import lombok.RequiredArgsConstructor;
import me.dio.decolha_tech_2025.domain.model.Compromisso;
import me.dio.decolha_tech_2025.domain.repository.CompromissoRepository;
import me.dio.decolha_tech_2025.service.CompromissoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompromissoServiceImpl implements CompromissoService {

    private final CompromissoRepository compromissoRepository;

    @Override
    public Compromisso save(Compromisso compromisso) {
        return compromissoRepository.save(compromisso);
    }

    @Override
    public Compromisso findById(Long id) {
        return compromissoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compromisso não encontrado!"));
    }

    @Override
    public List<Compromisso> findAll() {
        return compromissoRepository.findAll();
    }

    @Override
    public Compromisso update(Long id, Compromisso compromisso) {
        Compromisso compromissoExistente = findById(id);
        compromissoExistente.setTitulo(compromisso.getTitulo());
        compromissoExistente.setDescricao(compromisso.getDescricao());
        compromissoExistente.setDataHora(compromisso.getDataHora());
        compromissoExistente.setLocal(compromisso.getLocal());
        return compromissoRepository.save(compromissoExistente);
    }

    @Override
    public void delete(Long id) {
        Compromisso compromisso = findById(id);
        compromissoRepository.delete(compromisso);
    }

    @Override
    public List<Compromisso> findByUsuarioId(Long usuarioId) {
        return compromissoRepository.findByUsuarioId(usuarioId);
    }
}
