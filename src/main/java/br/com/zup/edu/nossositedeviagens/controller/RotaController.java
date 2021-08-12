package br.com.zup.edu.nossositedeviagens.controller;

import br.com.zup.edu.nossositedeviagens.dto.RotaRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rotas")
public class RotaController {

    @PostMapping
    public void cadastrar(@RequestBody RotaRequest request) {

    }


}
