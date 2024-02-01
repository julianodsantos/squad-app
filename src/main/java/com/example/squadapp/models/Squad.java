package com.example.squadapp.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Squad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSquad;

    private String nomeSquad;

    private String descricaoSquad;

    @OneToMany(mappedBy = "squad")
    private List<ColaboradorSquad> colaboradorSquadList;

    public Squad() {
    }

    public Long getIdSquad() {
        return idSquad;
    }

    public void setIdSquad(Long idSquad) {
        this.idSquad = idSquad;
    }

    public String getNomeSquad() {
        return nomeSquad;
    }

    public void setNomeSquad(String nomeSquad) {
        this.nomeSquad = nomeSquad;
    }

    public List<ColaboradorSquad> getColaboradorSquadList() {
        return colaboradorSquadList;
    }

    public void setColaboradorSquadList(List<ColaboradorSquad> colaboradorSquadList) {
        this.colaboradorSquadList = colaboradorSquadList;
    }

    public String getDescricaoSquad() {
        return descricaoSquad;
    }

    public void setDescricaoSquad(String descricaoSquad) {
        this.descricaoSquad = descricaoSquad;
    }
}