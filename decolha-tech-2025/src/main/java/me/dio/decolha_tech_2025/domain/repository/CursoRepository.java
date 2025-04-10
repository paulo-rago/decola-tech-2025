package me.dio.decolha_tech_2025.domain.repository;

import me.dio.decolha_tech_2025.domain.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
