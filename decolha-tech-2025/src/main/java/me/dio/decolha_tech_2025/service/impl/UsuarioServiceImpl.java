package me.dio.decolha_tech_2025.service.impl;

import lombok.RequiredArgsConstructor;
import me.dio.decolha_tech_2025.domain.model.Usuario;
import me.dio.decolha_tech_2025.domain.repository.UsuarioRepository;
import me.dio.decolha_tech_2025.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario update(Long id, Usuario usuario) {
        Usuario usuarioExistente = findById(id);
        usuarioExistente.setNome(usuario.getNome());
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setSenhaHash(usuario.getSenhaHash());
        return usuarioRepository.save(usuarioExistente);
    }

    @Override
    public void delete(Long id) {
        Usuario usuario = findById(id);
        usuarioRepository.delete(usuario);
    }
}
