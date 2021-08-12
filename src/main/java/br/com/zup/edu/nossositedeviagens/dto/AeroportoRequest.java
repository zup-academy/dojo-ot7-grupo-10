package br.com.zup.edu.nossositedeviagens.dto;

import br.com.zup.edu.nossositedeviagens.config.validation.ExistsOrUnique;
import br.com.zup.edu.nossositedeviagens.model.Aeroporto;
import br.com.zup.edu.nossositedeviagens.model.Companhia;
import br.com.zup.edu.nossositedeviagens.model.Pais;
import br.com.zup.edu.nossositedeviagens.repository.PaisRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Optional;

public class AeroportoRequest {

    @NotBlank
    @ExistsOrUnique(field = "nome", entity = Aeroporto.class, unique = true)
    private String nome;

    @NotNull
    private Long paisId;

    public Optional<Aeroporto> paraAeroporto(PaisRepository paisRepository){
        Optional<Pais> pais = paisRepository.findById(paisId);

        if (pais.isPresent()) {
            Aeroporto aeroporto = new Aeroporto(nome, pais.get());
            return Optional.of(aeroporto);
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
