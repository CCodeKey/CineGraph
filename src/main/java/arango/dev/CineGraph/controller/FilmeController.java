package arango.dev.CineGraph.controller;

import arango.dev.CineGraph.model.Avaliacao;
import arango.dev.CineGraph.model.Filme;
import arango.dev.CineGraph.model.dto.MediaFilmeDTO;
import arango.dev.CineGraph.service.AvaliacaoService;
import arango.dev.CineGraph.service.FilmeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService service;
    private final AvaliacaoService avaliacaoService;

    public FilmeController(FilmeService service, AvaliacaoService avaliacaoService) {
        this.service = service;
        this.avaliacaoService = avaliacaoService;
    }

    @PostMapping
    public Filme salvar(@Valid @RequestBody Filme filme) {
        return service.salvar(filme);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filme> atualizar(@PathVariable String id, @Valid @RequestBody Filme filme) {
        return ResponseEntity.ok(service.atualizar(id, filme));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/genero/{genero}")
    public ResponseEntity<List<Filme>> buscarPorGenero(@PathVariable String genero) {
        return ResponseEntity.ok(service.buscarPorGenero(genero));
    }

    @GetMapping
    public Iterable<Filme> listar() {
        return service.listar();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        service.deletar(id);
    }

    @GetMapping("/{id}/media")
    public ResponseEntity<MediaFilmeDTO> calcularMedia(@PathVariable String id) {
        List<Avaliacao> avaliacoes = avaliacaoService.buscarPorFilme(id);
        double media = avaliacaoService.calcularMediaFilme(id);
        return ResponseEntity.ok(new MediaFilmeDTO(id, media, avaliacoes.size()));
    }

}