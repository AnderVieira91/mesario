package com.organizador.campeonato.mesario.entidades.jpa;


import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


/**
 * Entidade que representa um time.
 *
 * @author andersonvieira
 */
@Entity
@Table(name = "TIME")
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TIME")
    @SequenceGenerator(name = "SEQ_TIME", sequenceName = "SEQ_TIME", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @OneToMany
    @JoinTable(
            name = "TIME_JOGADOR",
            joinColumns = @JoinColumn(name = "TIME_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "JOGADOR_ID")
    )
    private List<Jogador> jogadores;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TECNICO_ID", referencedColumnName = "ID")
    private Jogador tecnico;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Jogador> getJogadores() {
        return this.jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public Jogador getTecnico() {
        return this.tecnico;
    }

    public void setTecnico(Jogador tecnico) {
        this.tecnico = tecnico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o instanceof Time that) {
            return Objects.equals(this.id, that.id) &&
                    Objects.equals(this.nome, that.nome) &&
                    Objects.equals(this.jogadores, that.jogadores) &&
                    Objects.equals(this.tecnico, that.tecnico);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

}
