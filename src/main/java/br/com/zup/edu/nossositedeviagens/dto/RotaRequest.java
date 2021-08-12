package br.com.zup.edu.nossositedeviagens.dto;

import br.com.zup.edu.nossositedeviagens.model.Aeroporto;
import br.com.zup.edu.nossositedeviagens.model.Rota;
import br.com.zup.edu.nossositedeviagens.repository.AeroportoRepository;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Optional;

public class RotaRequest {

    private String nome;
    @NotNull
    private Long origem;
    @NotNull
    private Long destino;

    @Positive @NotNull
    private Long minutos;

    public String getNome() {
        return nome;
    }

    public Long getOrigem() {
        return origem;
    }

    public Long getDestino() {
        return destino;
    }

    public Long getMinutos() {
        return minutos;
    }

    public Rota toModel(AeroportoRepository repository){
        Optional<Aeroporto> aeroOrigem = repository.findById(this.origem);
        Optional<Aeroporto> aeroDestino = repository.findById(this.destino);
        return new Rota(nome, aeroOrigem.get(), aeroDestino.get(), minutos);
        
    }


}
