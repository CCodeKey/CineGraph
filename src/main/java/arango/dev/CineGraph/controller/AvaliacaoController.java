package arango.dev.CineGraph.controller;

import arango.dev.CineGraph.model.Avaliacao;
import arango.dev.CineGraph.service.AvaliacaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    private final AvaliacaoService service;

    public AvaliacaoController(AvaliacaoService service) {
        this.service = service;
    }

    @PostMapping
    public Avaliacao salvar(@Valid @RequestBody Avaliacao avaliacao) {
        return service.salvar(avaliacao);
    }

    @GetMapping("/filme/{id}")
    public ResponseEntity<List<Avaliacao>> buscarPorFilme(@PathVariable String id) {
        return ResponseEntity.ok(service.buscarPorFilme(id));
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<Avaliacao>> buscarPorUsuario(@PathVariable String id) {
        return ResponseEntity.ok(service.buscarPorUsuario(id));
    }

    @GetMapping
    public Iterable<Avaliacao> listar() {
        return service.listar();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        service.deletar(id);
    }

}