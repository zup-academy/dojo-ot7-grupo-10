package br.com.zup.edu.nossositedeviagens.controller;

import br.com.zup.edu.nossositedeviagens.dto.AeroportoRequest;
import br.com.zup.edu.nossositedeviagens.model.Aeroporto;
import br.com.zup.edu.nossositedeviagens.repository.CompanhiaRepository;
import br.com.zup.edu.nossositedeviagens.repository.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/aeroportos")
public class AeroportoController {

    private final PaisRepository paisRepository;

    public AeroportoController(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid AeroportoRequest req, UriComponentsBuilder uriBuilder) {
        Optional<Aeroporto> aeroporto = req.paraAeroporto(paisRepository);

        if(aeroporto.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        companhiaRepository.save(companhia.get());
        URI uri = uriBuilder.path("/companhia/{id}").buildAndExpand(companhia.get().getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
