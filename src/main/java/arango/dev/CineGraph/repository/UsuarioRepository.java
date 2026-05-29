package arango.dev.CineGraph.repository;

import arango.dev.CineGraph.model.Usuario;
import com.arangodb.springframework.repository.ArangoRepository;

public interface UsuarioRepository extends ArangoRepository<Usuario, String> {
}