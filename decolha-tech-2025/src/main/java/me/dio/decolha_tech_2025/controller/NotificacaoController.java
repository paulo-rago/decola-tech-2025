package me.dio.decolha_tech_2025.controller;

import lombok.RequiredArgsConstructor;
import me.dio.decolha_tech_2025.domain.model.Notificacao;
import me.dio.decolha_tech_2025.service.NotificacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificacoes")
@RequiredArgsConstructor
public class NotificacaoController {

    private final NotificacaoService notificacaoService;

    @PostMapping
    public ResponseEntity<Notificacao> save(@RequestBody Notificacao notificacao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(notificacaoService.save(notificacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notificacao> findById(@PathVariable Long id) {
        return ResponseEntity.ok(notificacaoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Notificacao>> findAll() {
        return ResponseEntity.ok(notificacaoService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notificacao> update(@PathVariable Long id, @RequestBody Notificacao notificacao) {
        return ResponseEntity.ok(notificacaoService.update(id, notificacao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        notificacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Notificacao>> findByUsuarioId(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(notificacaoService.findByUsuarioId(usuarioId));
    }

    @PatchMapping("/{id}/marcar-lido")
    public ResponseEntity<Void> marcarComoLido(@PathVariable Long id) {
        notificacaoService.marcarComoLido(id);
        return ResponseEntity.noContent().build();
    }
}
