package me.dio.decolha_tech_2025.controller;

import lombok.RequiredArgsConstructor;
import me.dio.decolha_tech_2025.domain.model.Disciplina;
import me.dio.decolha_tech_2025.service.DisciplinaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
@RequiredArgsConstructor
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    @PostMapping
    public ResponseEntity<Disciplina> save(@RequestBody Disciplina disciplina) {
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaService.save(disciplina));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> findById(@PathVariable Long id) {
        return ResponseEntity.ok(disciplinaService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Disciplina>> findAll() {
        return ResponseEntity.ok(disciplinaService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Disciplina> update(@PathVariable Long id, @RequestBody Disciplina disciplina) {
        return ResponseEntity.ok(disciplinaService.update(id, disciplina));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        disciplinaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
