package br.com.zup.edu.nossositedeviagens.repository;

import br.com.zup.edu.nossositedeviagens.model.Rota;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RotaRepository extends CrudRepository<Rota, Long> {

    @Query("SELECT 1 FROM Rota r WHERE r.origem.id = :idOrigem AND r.destino.id= :idDestino")
    public Optional<Rota> buscarRotaPorAeroportos(Long idOrigem, Long idDestino);

}
