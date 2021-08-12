package br.com.zup.edu.nossositedeviagens.controller;

import br.com.zup.edu.nossositedeviagens.dto.RotaRequest;
import br.com.zup.edu.nossositedeviagens.repository.AeroportoRepository;
import br.com.zup.edu.nossositedeviagens.repository.RotaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rotas")
public class RotaController {

    private final AeroportoRepository aeroportoRepository;

    private final RotaRepository rotaRepository;

    public RotaController(AeroportoRepository aeroportoRepository, RotaRepository rotaRepository) {
        this.aeroportoRepository = aeroportoRepository;
        this.rotaRepository = rotaRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody RotaRequest request) {
        if (request.rotaJaExistente(rotaRepository)) {
            return ResponseEntity.badRequest().build();
        }
        if (request.mesmoAeroporto()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}
