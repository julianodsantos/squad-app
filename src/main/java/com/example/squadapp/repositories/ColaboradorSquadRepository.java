package com.example.squadapp.repositories;

import com.example.squadapp.models.Colaborador;
import com.example.squadapp.models.ColaboradorSquad;
import com.example.squadapp.models.Squad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColaboradorSquadRepository extends JpaRepository<ColaboradorSquad, Long> {
    boolean existsByColaboradorAndSquad(Colaborador colaborador, Squad squad);
}
