package arango.dev.CineGraph.repository;

import arango.dev.CineGraph.model.Filme;
import com.arangodb.springframework.repository.ArangoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends ArangoRepository<Filme, String> {
}