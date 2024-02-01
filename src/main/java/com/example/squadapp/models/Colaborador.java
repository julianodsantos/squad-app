package com.example.squadapp.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idColaborador;

    private String nome;
    private String cargo;

    @OneToMany(mappedBy = "colaborador")
    private List<ColaboradorSquad> colaboradorSquads;

    public Colaborador() {
    }

    public Long getIdColaborador() {
        return idColaborador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public List<ColaboradorSquad> getColaboradorSquads() {
        return colaboradorSquads;
    }

    public void setColaboradorSquads(List<ColaboradorSquad> colaboradorSquads) {
        this.colaboradorSquads = colaboradorSquads;
    }
}