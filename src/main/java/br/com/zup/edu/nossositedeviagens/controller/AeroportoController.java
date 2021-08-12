package br.com.zup.edu.nossositedeviagens.controller;

import br.com.zup.edu.nossositedeviagens.dto.AeroportoRequest;
import br.com.zup.edu.nossositedeviagens.model.Aeroporto;
import br.com.zup.edu.nossositedeviagens.repository.AeroportoRepository;
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

    private final AeroportoRepository aeroportoRepository;

    public AeroportoController(PaisRepository paisRepository, AeroportoRepository aeroportoRepository) {
        this.paisRepository = paisRepository;
        this.aeroportoRepository = aeroportoRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid AeroportoRequest req, UriComponentsBuilder uriBuilder) {
        Optional<Aeroporto> aeroporto = req.paraAeroporto(paisRepository);

        if(aeroporto.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        aeroportoRepository.save(aeroporto.get());
        URI uri = uriBuilder.path("/aeroporto/{id}").buildAndExpand(aeroporto.get().getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
