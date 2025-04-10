package me.dio.decolha_tech_2025.controller;

import lombok.RequiredArgsConstructor;
import me.dio.decolha_tech_2025.domain.model.Compromisso;
import me.dio.decolha_tech_2025.service.CompromissoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compromissos")
@RequiredArgsConstructor
public class CompromissoController {

    private final CompromissoService compromissoService;

    @PostMapping
    public ResponseEntity<Compromisso> save(@RequestBody Compromisso compromisso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(compromissoService.save(compromisso));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compromisso> findById(@PathVariable Long id) {
        return ResponseEntity.ok(compromissoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Compromisso>> findAll() {
        return ResponseEntity.ok(compromissoService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compromisso> update(@PathVariable Long id, @RequestBody Compromisso compromisso) {
        return ResponseEntity.ok(compromissoService.update(id, compromisso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        compromissoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Compromisso>> findByUsuarioId(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(compromissoService.findByUsuarioId(usuarioId));
    }
}
