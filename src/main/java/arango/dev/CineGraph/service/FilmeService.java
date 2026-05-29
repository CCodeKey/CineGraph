package arango.dev.CineGraph.service;

import arango.dev.CineGraph.model.Filme;
import arango.dev.CineGraph.repository.FilmeRepository;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {

    private final FilmeRepository repository;

    public FilmeService(FilmeRepository repository) {
        this.repository = repository;
    }

    public Iterable<Filme> listar() {
        return repository.findAll();
    }

    public Filme salvar(Filme filme) {
        return repository.save(filme);
    }

    public void deletar(String id) {
        repository.deleteById(id);
    }
}