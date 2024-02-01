package com.example.squadapp.controllers;

import com.example.squadapp.models.Colaborador;
import com.example.squadapp.models.Squad;
import com.example.squadapp.repositories.ColaboradorRepository;
import com.example.squadapp.repositories.SquadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/squad")
public class SquadController {

    @Autowired
    private SquadRepository squadRepository;

    @GetMapping("/cadastro")
    public String exibirPaginaCadastroSquad() {
        return "cadastro-squad";
    }

    @GetMapping("/pesquisar")
    public String exibirPaginaPesquisaSquad() {
        return "pesquisa-squad";
    }

    @PostMapping("/salvar")
    public String salvarColaborador(Squad squad) {
        squadRepository.save(squad);
        return "cadastro-squad";
    }

    @PostMapping("/pesquisar")
    public String pesquisarSquad(@RequestParam String nomeSquad, Model model) {
        List<Squad> squadsEncontradas = squadRepository.findSquadByNomeSquadContainingIgnoreCase(nomeSquad);
        model.addAttribute("squadsEncontradas", squadsEncontradas);
        return "pesquisa-squad";
    }
}
