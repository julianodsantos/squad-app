package com.example.squadapp.controllers;

import com.example.squadapp.models.Colaborador;
import com.example.squadapp.repositories.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/colaborador")
public class ColaboradorController {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @GetMapping("/cadastro")
    public String exibirPaginaCadastroColaborador() {
        return "cadastro-colaborador";
    }

    @GetMapping("/pesquisar")
    public String exibirPaginaPesquisaColaborador() {
        return "pesquisa-colaborador";
    }

    @PostMapping("/cadastro")
    public String salvarColaborador(Colaborador colaborador, RedirectAttributes redirectAttributes) {
        colaboradorRepository.save(colaborador);
        redirectAttributes.addFlashAttribute("mensagem", "Cadastro salvo com sucesso!");
        return exibirPaginaCadastroColaborador();
    }

    @PostMapping("/pesquisar")
    public String pesquisarColaboradores(@RequestParam("termoPesquisa") String termoPesquisa, Model model) {
        List<Colaborador> colaboradoresEncontrados = colaboradorRepository.findByNomeContainingIgnoreCase(termoPesquisa);
        model.addAttribute("colaboradoresEncontrados", colaboradoresEncontrados);
        return "pesquisa-colaborador";
    }
}
