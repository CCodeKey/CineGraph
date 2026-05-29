package arango.dev.CineGraph.repository;

import arango.dev.CineGraph.model.Avaliacao;
import com.arangodb.springframework.repository.ArangoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoRepository extends ArangoRepository<Avaliacao, String> {
}