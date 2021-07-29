package br.com.zup.edu.nossositedeviagens.controller;

import br.com.zup.edu.nossositedeviagens.dto.CompanhiaRequest;
import br.com.zup.edu.nossositedeviagens.dto.PaisRequest;
import br.com.zup.edu.nossositedeviagens.model.Companhia;
import br.com.zup.edu.nossositedeviagens.model.Pais;
import br.com.zup.edu.nossositedeviagens.repository.CompanhiaRepository;
import br.com.zup.edu.nossositedeviagens.repository.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/companhia")
public class CompanhiaController {

    private CompanhiaRepository companhiaRepository;
    private PaisRepository paisRepository;

    public CompanhiaController(CompanhiaRepository companhiaRepository, PaisRepository paisRepository) {
        this.companhiaRepository = companhiaRepository;
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid CompanhiaRequest req, UriComponentsBuilder uriBuilder) {
        Optional<Companhia> companhia = req.criaCompanhia(paisRepository);

        if(companhia.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        companhiaRepository.save(companhia.get());
        URI uri = uriBuilder.path("/companhia/{id}").buildAndExpand(companhia.get().getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
