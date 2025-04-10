package me.dio.decolha_tech_2025.domain.repository;

import me.dio.decolha_tech_2025.domain.model.Compromisso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompromissoRepository extends JpaRepository<Compromisso, Long> {

    List<Compromisso> findByUsuarioId(Long usuarioId);
}
