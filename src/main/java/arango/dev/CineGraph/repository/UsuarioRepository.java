package arango.dev.CineGraph.repository;

import arango.dev.CineGraph.model.Usuario;
import com.arangodb.springframework.repository.ArangoRepository;

import java.util.Optional;

public interface UsuarioRepository extends ArangoRepository<Usuario, String> {
    Optional<Usuario> findByEmail(String email);
}