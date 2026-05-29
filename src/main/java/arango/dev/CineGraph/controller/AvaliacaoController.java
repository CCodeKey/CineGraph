package arango.dev.CineGraph.controller;

import arango.dev.CineGraph.model.Avaliacao;
import arango.dev.CineGraph.service.AvaliacaoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    private final AvaliacaoService service;

    public AvaliacaoController(AvaliacaoService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Avaliacao> listar() {
        return service.listar();
    }

    @PostMapping
    public Avaliacao salvar(@RequestBody Avaliacao avaliacao) {
        return service.salvar(avaliacao);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        service.deletar(id);
    }
}