package com.example.squadapp.repositories;

import com.example.squadapp.controllers.ColaboradorController;
import com.example.squadapp.models.Colaborador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
    List<Colaborador> findByNomeContainingIgnoreCase(String termoPesquisa);
}
