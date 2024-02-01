package com.example.squadapp.models;


import jakarta.persistence.*;

@Entity
public class ColaboradorSquad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idColaboradorSquad;

    @ManyToOne
    @JoinColumn(name = "idColaborador")
    private Colaborador colaborador;

    @ManyToOne
    @JoinColumn(name = "idSquad")
    private Squad squad;

    public ColaboradorSquad() {
    }

    public Long getIdColaboradorSquad() {
        return idColaboradorSquad;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public Squad getSquad() {
        return squad;
    }

    public void setSquad(Squad squad) {
        this.squad = squad;
    }
}