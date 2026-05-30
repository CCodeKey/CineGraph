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
@RequestMapping("/")
public class ViewController {

    private final FilmeService filmeService;
    private final UsuarioService usuarioService;
    private final AvaliacaoService avaliacaoService;

    public ViewController(FilmeService filmeService, UsuarioService usuarioService, AvaliacaoService avaliacaoService) {
        this.filmeService = filmeService;
        this.usuarioService = usuarioService;
        this.avaliacaoService = avaliacaoService;
    }

    // Página Principal (Dashboard)
    @GetMapping
    public String index(Model model) {
        model.addAttribute("filmes", filmeService.listar());
        model.addAttribute("usuarios", usuarioService.listar());
        model.addAttribute("avaliacoes", avaliacaoService.listar());
        return "index";
    }

    // ========== FLUXO DE FILMES ==========
    @GetMapping("/web/filmes/novo")
    public String formularioFilme(Model model) {
        model.addAttribute("filme", new Filme());
        return "form-filme";
    }

    @PostMapping("/web/filmes/salvar")
    public String salvarFilme(@ModelAttribute Filme filme) {
        filmeService.salvar(filme);
        return "redirect:/";
    }

    @GetMapping("/web/filmes/deletar/{id}")
    public String deletarFilme(@PathVariable String id) {
        filmeService.deletar(id);
        return "redirect:/";
    }

    // ========== FLUXO DE USUÁRIOS ==========
    @GetMapping("/web/usuarios/novo")
    public String formularioUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "form-usuario";
    }

    @PostMapping("/web/usuarios/salvar")
    public String salvarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.salvar(usuario);
        return "redirect:/";
    }

    @GetMapping("/web/usuarios/deletar/{id}")
    public String deletarUsuario(@PathVariable String id) {
        usuarioService.deletar(id);
        return "redirect:/";
    }

    // ========== FLUXO DE AVALIAÇÕES ==========
    @GetMapping("/web/avaliacoes/novo")
    public String formularioAvaliacao(Model model) {
        model.addAttribute("avaliacao", new Avaliacao());
        model.addAttribute("todosFilmes", filmeService.listar());
        model.addAttribute("todosUsuarios", usuarioService.listar());
        return "form-avaliacao";
    }

    @PostMapping("/web/avaliacoes/salvar")
    public String salvarAvaliacao(@ModelAttribute Avaliacao avaliacao) {
        avaliacaoService.salvar(avaliacao);
        return "redirect:/";
    }

    @GetMapping("/web/avaliacoes/deletar/{id}")
    public String deletarAvaliacao(@PathVariable String id) {
        avaliacaoService.deletar(id);
        return "redirect:/";
    }
}