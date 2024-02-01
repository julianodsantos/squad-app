package com.example.squadapp.repositories;

import com.example.squadapp.models.Squad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SquadRepository extends JpaRepository<Squad, Long> {
    List<Squad> findSquadByNomeSquadContainingIgnoreCase (String termoPesquisa);
}
