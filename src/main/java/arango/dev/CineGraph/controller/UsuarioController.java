package arango.dev.CineGraph.controller;

import arango.dev.CineGraph.model.Avaliacao;
import arango.dev.CineGraph.model.Usuario;
import arango.dev.CineGraph.model.dto.UsuarioDTO;
import arango.dev.CineGraph.service.AvaliacaoService;
import arango.dev.CineGraph.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final AvaliacaoService avaliacaoService;

    public UsuarioController(UsuarioService usuarioService, AvaliacaoService avaliacaoService) {
        this.usuarioService = usuarioService;
        this.avaliacaoService = avaliacaoService;
    }

    @PostMapping
    public Usuario salvar(@Valid @RequestBody Usuario usuario) {
        return usuarioService.salvar(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable String id, @Valid @RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.atualizar(id, usuario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }

    @GetMapping("/email")
    public ResponseEntity<Usuario> buscarPorEmail(@RequestBody UsuarioDTO usuario) {
        return ResponseEntity.ok(usuarioService.buscarPorEmail(usuario.email()));
    }

    @GetMapping("/{id}/avaliacoes")
    public ResponseEntity<List<Avaliacao>> buscarAvaliacoesUsuario(@PathVariable String id) {
        return ResponseEntity.ok(avaliacaoService.buscarPorUsuario(id));
    }

    @GetMapping
    public Iterable<Usuario> listar() {
        return usuarioService.listar();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        usuarioService.deletar(id);
    }

}