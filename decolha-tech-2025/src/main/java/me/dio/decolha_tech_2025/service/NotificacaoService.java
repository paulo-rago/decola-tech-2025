package me.dio.decolha_tech_2025.service;

import me.dio.decolha_tech_2025.domain.model.Notificacao;

import java.util.List;

public interface NotificacaoService {

    Notificacao save(Notificacao notificacao);
    Notificacao findById(Long id);
    List<Notificacao> findAll();
    Notificacao update(Long id, Notificacao notificacao);
    void delete(Long id);

    List<Notificacao> findByUsuarioId(Long usuarioId);

    void marcarComoLido(Long id);
}
