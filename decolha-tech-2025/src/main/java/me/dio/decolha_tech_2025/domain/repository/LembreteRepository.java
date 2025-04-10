package me.dio.decolha_tech_2025.domain.repository;

import me.dio.decolha_tech_2025.domain.model.Lembrete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LembreteRepository extends JpaRepository<Lembrete, Long> {
}
