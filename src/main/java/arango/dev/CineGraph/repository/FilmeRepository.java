package arango.dev.CineGraph.repository;

import arango.dev.CineGraph.model.Filme;
import com.arangodb.springframework.repository.ArangoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends ArangoRepository<Filme, String> {
    List<Filme> findByGenero(String genero);
}