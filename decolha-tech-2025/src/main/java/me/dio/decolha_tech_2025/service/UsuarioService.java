package me.dio.decolha_tech_2025.service;

import me.dio.decolha_tech_2025.domain.model.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario save(Usuario usuario);
    Usuario findById(Long id);
    List<Usuario> findAll();
    Usuario update(Long id, Usuario usuario);
    void delete(Long id);
}
