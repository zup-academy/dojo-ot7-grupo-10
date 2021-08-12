package br.com.zup.edu.nossositedeviagens.dto;

import br.com.zup.edu.nossositedeviagens.config.validation.ExistsOrUnique;
import br.com.zup.edu.nossositedeviagens.model.Companhia;
import br.com.zup.edu.nossositedeviagens.model.Pais;
import br.com.zup.edu.nossositedeviagens.repository.PaisRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Optional;

public class CompanhiaRequest {

    @NotBlank
    @ExistsOrUnique(field = "nome", entity = Companhia.class, unique = true)
    private String nome;

    @NotNull
    @ExistsOrUnique(field = "id", entity = Pais.class)
    private Long paisId;

    public Optional<Companhia> criaCompanhia(PaisRepository paisRepository) {
        Optional<Pais> pais = paisRepository.findById(paisId);

        if (pais.isPresent()) {
            Companhia companhia = new Companhia(nome, Instant.now(), pais.get());
            return Optional.of(companhia);
        }

        return Optional.empty();
    }

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }
}
