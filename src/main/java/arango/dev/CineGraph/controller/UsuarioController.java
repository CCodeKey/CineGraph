package arango.dev.CineGraph.controller;

import arango.dev.CineGraph.model.Usuario;
import arango.dev.CineGraph.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario salvar(@RequestBody Usuario usuario) {
        return usuarioService.salvar(usuario);
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