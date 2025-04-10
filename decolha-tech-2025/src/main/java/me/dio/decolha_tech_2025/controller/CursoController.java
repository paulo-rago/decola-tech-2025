package me.dio.decolha_tech_2025.controller;

import lombok.RequiredArgsConstructor;
import me.dio.decolha_tech_2025.domain.model.Curso;
import me.dio.decolha_tech_2025.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import me.dio.decolha_tech_2025.domain.model.dto.CursoResponse;

import java.util.List;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService cursoService;

    @PostMapping
    public ResponseEntity<Curso> save(@RequestBody Curso curso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.save(curso));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponse> findById(@PathVariable Long id) {
        Curso curso = cursoService.findById(id);

        CursoResponse response = new CursoResponse();
        response.setId(curso.getId());
        response.setNome(curso.getNome());
        response.setDescricao(curso.getDescricao());

        return ResponseEntity.ok(response);
    }


    @GetMapping
    public ResponseEntity<List<Curso>> findAll() {
        return ResponseEntity.ok(cursoService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> update(@PathVariable Long id, @RequestBody Curso curso) {
        return ResponseEntity.ok(cursoService.update(id, curso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cursoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
