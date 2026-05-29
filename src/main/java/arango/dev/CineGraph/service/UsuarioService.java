package arango.dev.CineGraph.service;

import arango.dev.CineGraph.model.Usuario;
import arango.dev.CineGraph.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Iterable<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public void deletar(String id) {
        usuarioRepository.deleteById(id);
    }
}