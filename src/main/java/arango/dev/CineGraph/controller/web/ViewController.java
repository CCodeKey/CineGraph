package arango.dev.CineGraph.controller.web;

import arango.dev.CineGraph.model.Avaliacao;
import arango.dev.CineGraph.model.Filme;
import arango.dev.CineGraph.model.Usuario;
import arango.dev.CineGraph.service.AvaliacaoService;
import arango.dev.CineGraph.service.FilmeService;
import arango.dev.CineGraph.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web")
public class ViewController {

    private final FilmeService filmeService;
    private final UsuarioService usuarioService;
    private final AvaliacaoService avaliacaoService;

    public ViewController(FilmeService filmeService, UsuarioService usuarioService, AvaliacaoService avaliacaoService) {
        this.filmeService = filmeService;
        this.usuarioService = usuarioService;
        this.avaliacaoService = avaliacaoService;
    }

    // Mapeado para responder em http://localhost:8080/web ou http://localhost:8080/web/painel
    @GetMapping({"", "/", "/painel"})
    public String index(Model model) {
        model.addAttribute("filmes", filmeService.listar());
        model.addAttribute("usuarios", usuarioService.listar());
        model.addAttribute("avaliacoes", avaliacaoService.listar());
        return "index";
    }

    // ========== FLUXO DE FILMES ==========
    @GetMapping("/filmes/novo")
    public String formularioFilme(Model model) {
        model.addAttribute("filme", new Filme());
        return "form-filme";
    }

    @PostMapping("/filmes/salvar")
    public String salvarFilme(@ModelAttribute Filme filme) {
        filmeService.salvar(filme);
        return "redirect:/web/painel";
    }

    @GetMapping("/filmes/deletar/{id}")
    public String deletarFilme(@PathVariable String id) {
        filmeService.deletar(id);
        return "redirect:/web/painel";
    }

    // ========== FLUXO DE USUÁRIOS ==========
    @GetMapping("/usuarios/novo")
    public String formularioUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "form-usuario";
    }

    @PostMapping("/usuarios/salvar")
    public String salvarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.salvar(usuario);
        return "redirect:/web/painel";
    }

    @GetMapping("/usuarios/deletar/{id}")
    public String deletarUsuario(@PathVariable String id) {
        usuarioService.deletar(id);
        return "redirect:/web/painel";
    }

    // ========== FLUXO DE AVALIAÇÕES ==========
    @GetMapping("/avaliacoes/novo")
    public String formularioAvaliacao(Model model) {
        model.addAttribute("avaliacao", new Avaliacao());
        model.addAttribute("todosFilmes", filmeService.listar());
        model.addAttribute("todosUsuarios", usuarioService.listar());
        return "form-avaliacao";
    }

    @PostMapping("/avaliacoes/salvar")
    public String salvarAvaliacao(@ModelAttribute Avaliacao avaliacao) {
        avaliacaoService.salvar(avaliacao);
        return "redirect:/web/painel";
    }

    @GetMapping("/avaliacoes/deletar/{id}")
    public String deletarAvaliacao(@PathVariable String id) {
        avaliacaoService.deletar(id);
        return "redirect:/web/painel";
    }
}