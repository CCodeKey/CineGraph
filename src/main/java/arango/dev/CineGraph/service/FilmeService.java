package arango.dev.CineGraph.service;

import arango.dev.CineGraph.model.Filme;
import arango.dev.CineGraph.repository.FilmeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    private final FilmeRepository repository;

    public FilmeService(FilmeRepository repository) {
        this.repository = repository;
    }

    public Filme salvar(Filme filme) {
        return repository.save(filme);
    }

    public Filme atualizar(String id, Filme filmeAtualizado) {
        Filme filme = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        filme.setTitulo(filmeAtualizado.getTitulo());
        filme.setGenero(filmeAtualizado.getGenero());
        filme.setAno(filmeAtualizado.getAno());

        return repository.save(filme);
    }

    public Filme buscarPorId(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));
    }

    public List<Filme> buscarPorGenero(String genero) {
        return repository.findByGenero(genero);
    }

    public Iterable<Filme> listar() {
        return repository.findAll();
    }

    public void deletar(String id) {
        repository.deleteById(id);
    }

}