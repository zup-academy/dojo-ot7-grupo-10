package br.com.zup.edu.nossositedeviagens.dto;

import br.com.zup.edu.nossositedeviagens.model.Pais;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }

    public Pais criaPais() {
        return new Pais(this.nome);
    }
}
