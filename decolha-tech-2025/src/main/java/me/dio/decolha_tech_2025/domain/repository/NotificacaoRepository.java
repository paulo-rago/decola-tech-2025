package me.dio.decolha_tech_2025.domain.repository;

import me.dio.decolha_tech_2025.domain.model.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {

    List<Notificacao> findByUsuarioId(Long usuarioId);
}
