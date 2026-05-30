package arango.dev.CineGraph.service;

import arango.dev.CineGraph.model.Avaliacao;
import arango.dev.CineGraph.repository.AvaliacaoRepository;
import arango.dev.CineGraph.repository.FilmeRepository;
import arango.dev.CineGraph.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;
    private final UsuarioRepository usuarioRepository;
    private final FilmeRepository filmeRepository;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository, UsuarioRepository usuarioRepository, FilmeRepository filmeRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
        this.usuarioRepository = usuarioRepository;
        this.filmeRepository = filmeRepository;
    }

    public Avaliacao salvar(Avaliacao avaliacao) {
        if (!usuarioRepository.existsById(avaliacao.getUsuarioId())) {
            throw new RuntimeException("Usuário não encontrado");
        }

        if (!filmeRepository.existsById(avaliacao.getFilmeId())) {
            throw new RuntimeException("Filme não encontrado");
        }
        return avaliacaoRepository.save(avaliacao);
    }

    public List<Avaliacao> buscarPorFilme(String filmeId) {
        return avaliacaoRepository.findByFilmeId(filmeId);
    }

    public List<Avaliacao> buscarPorUsuario(String usuarioId) {
        return avaliacaoRepository.findByUsuarioId(usuarioId);
    }

    public Iterable<Avaliacao> listar() {
        return avaliacaoRepository.findAll();
    }

    public void deletar(String id) {
        avaliacaoRepository.deleteById(id);
    }

    public Double calcularMediaFilme(String filmeId) {
        List<Avaliacao> avaliacoes = avaliacaoRepository.findByFilmeId(filmeId);
        if (avaliacoes.isEmpty()) {
            return 0.0;
        }

        double soma = avaliacoes.stream()
                .mapToInt(Avaliacao::getNota)
                .sum();
        return soma / avaliacoes.size();
    }

}