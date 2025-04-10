package me.dio.decolha_tech_2025.service.impl;

import lombok.RequiredArgsConstructor;
import me.dio.decolha_tech_2025.domain.model.Notificacao;
import me.dio.decolha_tech_2025.domain.repository.NotificacaoRepository;
import me.dio.decolha_tech_2025.service.NotificacaoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificacaoServiceImpl implements NotificacaoService {

    private final NotificacaoRepository notificacaoRepository;

    @Override
    public Notificacao save(Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }

    @Override
    public Notificacao findById(Long id) {
        return notificacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notificação não encontrada!"));
    }

    @Override
    public List<Notificacao> findAll() {
        return notificacaoRepository.findAll();
    }

    @Override
    public Notificacao update(Long id, Notificacao notificacao) {
        Notificacao notificacaoExistente = findById(id);
        notificacaoExistente.setTipo(notificacao.getTipo());
        notificacaoExistente.setCanal(notificacao.getCanal());
        notificacaoExistente.setEnviadoEm(notificacao.getEnviadoEm());
        notificacaoExistente.setLido(notificacao.getLido());
        notificacaoExistente.setUsuario(notificacao.getUsuario());
        notificacaoExistente.setCompromisso(notificacao.getCompromisso());
        return notificacaoRepository.save(notificacaoExistente);
    }

    @Override
    public void delete(Long id) {
        Notificacao notificacao = findById(id);
        notificacaoRepository.delete(notificacao);
    }

    @Override
    public List<Notificacao> findByUsuarioId(Long usuarioId) {
        return notificacaoRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public void marcarComoLido(Long id) {
        Notificacao notificacao = findById(id);
        notificacao.setLido(true);
        notificacaoRepository.save(notificacao);
    }
}
