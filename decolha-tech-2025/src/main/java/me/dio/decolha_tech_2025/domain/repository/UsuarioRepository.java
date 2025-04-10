package me.dio.decolha_tech_2025.domain.repository;

import me.dio.decolha_tech_2025.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsById(Long id);
}
