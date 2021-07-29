package br.com.zup.edu.nossositedeviagens.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Entity
public class Companhia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String nome;

    private Instant instanteDaCriacao;

    @NotNull
    @ManyToOne
    private Pais pais;

    public Companhia(String nome, Instant instanteDaCriacao, Pais pais) {
        this.nome = nome;
        this.instanteDaCriacao = instanteDaCriacao;
        this.pais = pais;
    }

    @Deprecated
    public Companhia() {
    }

    public Long getId() {
        return id;
    }
}
