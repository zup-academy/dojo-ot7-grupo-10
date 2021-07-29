package br.com.zup.edu.nossositedeviagens.dto;

import br.com.zup.edu.nossositedeviagens.model.Companhia;
import br.com.zup.edu.nossositedeviagens.model.Pais;
import br.com.zup.edu.nossositedeviagens.repository.PaisRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Optional;

public class CompanhiaRequest {

    @NotBlank
    private String nome;

    private Instant instante;

    @NotNull
    private Long paisId;


    public Optional<Companhia> criaCompanhia(PaisRepository paisRepository) {
        Optional<Pais> pais = paisRepository.findById(paisId);

        return null;
    }
}
