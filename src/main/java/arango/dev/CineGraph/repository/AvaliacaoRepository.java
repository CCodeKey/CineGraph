package arango.dev.CineGraph.repository;

import arango.dev.CineGraph.model.Avaliacao;
import com.arangodb.springframework.repository.ArangoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends ArangoRepository<Avaliacao, String> {

    List<Avaliacao> findByFilmeId(String filmeId);

    List<Avaliacao> findByUsuarioId(String usuarioId);
}