package me.dio.decolha_tech_2025.controller;

import lombok.RequiredArgsConstructor;
import me.dio.decolha_tech_2025.domain.model.Lembrete;
import me.dio.decolha_tech_2025.service.LembreteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lembretes")
@RequiredArgsConstructor
public class LembreteController {

    private final LembreteService lembreteService;

    @PostMapping
    public ResponseEntity<Lembrete> save(@RequestBody Lembrete lembrete) {
        return ResponseEntity.status(HttpStatus.CREATED).body(lembreteService.save(lembrete));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lembrete> findById(@PathVariable Long id) {
        return ResponseEntity.ok(lembreteService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Lembrete>> findAll() {
        return ResponseEntity.ok(lembreteService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lembrete> update(@PathVariable Long id, @RequestBody Lembrete lembrete) {
        return ResponseEntity.ok(lembreteService.update(id, lembrete));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        lembreteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
