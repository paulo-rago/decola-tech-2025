package me.dio.decolha_tech_2025.domain.repository;

import me.dio.decolha_tech_2025.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacaoRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNome(String nome);
    boolean existsByNome(String nome);
    boolean existsById(Long id);
}
