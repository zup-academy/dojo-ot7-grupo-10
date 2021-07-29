package br.com.zup.edu.nossositedeviagens.controller;

import br.com.zup.edu.nossositedeviagens.dto.PaisRequest;
import br.com.zup.edu.nossositedeviagens.model.Pais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.zup.edu.nossositedeviagens.repository.PaisRepository;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    private PaisRepository repository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid PaisRequest req) {
        Pais pais = req.criaPais();
        repository.save(pais);
        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(pais.getId()).toUri();
        return ResponseEntity.created().build();
    }

}
