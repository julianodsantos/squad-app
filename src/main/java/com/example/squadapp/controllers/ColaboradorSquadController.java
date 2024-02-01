package com.example.squadapp.controllers;

import com.example.squadapp.models.Colaborador;
import com.example.squadapp.models.ColaboradorSquad;
import com.example.squadapp.models.Squad;
import com.example.squadapp.repositories.ColaboradorRepository;
import com.example.squadapp.repositories.ColaboradorSquadRepository;
import com.example.squadapp.repositories.SquadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/colaboradorSquad")
public class ColaboradorSquadController {

    @Autowired
    private SquadRepository squadRepository;

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private ColaboradorSquadRepository colaboradorSquadRepository;

    @GetMapping("/cadastro")
    public String exibirTelaCadastro(Model model) {
        List<Squad> squadsEncontradas = squadRepository.findAll();
        List<Colaborador> colaboradoresEncontrados = colaboradorRepository.findAll();

        model.addAttribute("squadsEncontradas", squadsEncontradas);
        model.addAttribute("colaboradoresEncontrados", colaboradoresEncontrados);
        model.addAttribute("colaboradorSquad", new ColaboradorSquad());

        return "movimento-squad";
    }

    @PostMapping("/salvar")
    public String salvarColaboradorSquad(@ModelAttribute ColaboradorSquad colaboradorSquad,
                                         RedirectAttributes redirectAttributes) {
        if (colaboradorSquadRepository.existsByColaboradorAndSquad(colaboradorSquad.getColaborador(), colaboradorSquad.getSquad())) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Colaborador já pertence ao Squad!");
            return "redirect:/colaboradorSquad/cadastro";
        }

        colaboradorSquadRepository.save(colaboradorSquad);
        redirectAttributes.addFlashAttribute("mensagemValidacao", "Colaborador adicionado ao Squad com sucesso!");
        return "redirect:/colaboradorSquad/cadastro";
    }
}
