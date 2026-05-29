package arango.dev.CineGraph.service;

import arango.dev.CineGraph.model.Avaliacao;
import arango.dev.CineGraph.repository.AvaliacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository repository;

    public AvaliacaoService(AvaliacaoRepository repository) {
        this.repository = repository;
    }

    public Iterable<Avaliacao> listar() {
        return repository.findAll();
    }

    public Avaliacao salvar(Avaliacao avaliacao) {
        return repository.save(avaliacao);
    }

    public void deletar(String id) {
        repository.deleteById(id);
    }
}