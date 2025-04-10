package me.dio.decolha_tech_2025.service.impl;

import lombok.RequiredArgsConstructor;
import me.dio.decolha_tech_2025.domain.model.Lembrete;
import me.dio.decolha_tech_2025.domain.repository.LembreteRepository;
import me.dio.decolha_tech_2025.service.LembreteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LembreteServiceImpl implements LembreteService {

    private final LembreteRepository lembreteRepository;

    @Override
    public Lembrete save(Lembrete lembrete) {
        return lembreteRepository.save(lembrete);
    }

    @Override
    public Lembrete findById(Long id) {
        return lembreteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lembrete não encontrado!"));
    }

    @Override
    public List<Lembrete> findAll() {
        return lembreteRepository.findAll();
    }

    @Override
    public Lembrete update(Long id, Lembrete lembrete) {
        Lembrete lembreteExistente = findById(id);
        lembreteExistente.setDataHora(lembrete.getDataHora());
        lembreteExistente.setMensagem(lembrete.getMensagem());
        lembreteExistente.setUsuario(lembrete.getUsuario());
        lembreteExistente.setCompromisso(lembrete.getCompromisso());
        return lembreteRepository.save(lembreteExistente);
    }

    @Override
    public void delete(Long id) {
        Lembrete lembrete = findById(id);
        lembreteRepository.delete(lembrete);
    }
}
