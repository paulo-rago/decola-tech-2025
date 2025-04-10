package me.dio.decolha_tech_2025.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name = "notificacao")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipo;
    @Column(nullable = false)// ex: "Email", "Push"
    private String canal; // ex: "Gmail", "App"

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime enviadoEm;

    @Column(nullable = false)
    private Boolean lido;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Compromisso compromisso;
}

