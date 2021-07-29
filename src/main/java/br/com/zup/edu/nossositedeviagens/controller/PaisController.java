package br.com.zup.edu.nossositedeviagens.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    private PaisRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid PaisRequest req) {
        Pais pais = req.criaPais();
    }

}
