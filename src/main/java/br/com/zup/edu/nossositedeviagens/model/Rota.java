package br.com.zup.edu.nossositedeviagens.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.Duration;

@Entity
public class Rota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    @ManyToOne
    private Aeroporto origem;

    @NotNull
    @ManyToOne
    private Aeroporto destino;

    @Positive @NotNull
    private Duration duracao;

    public Rota(String nome, Aeroporto origem, Aeroporto destino, Long duracao) {
        this.nome = nome;
        this.origem = origem;
        this.destino = destino;
        this.duracao = Duration.ofMinutes(duracao);
    }

    @Deprecated
    public Rota(){}
}
