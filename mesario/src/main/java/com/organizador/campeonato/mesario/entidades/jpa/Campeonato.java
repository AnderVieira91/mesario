package com.organizador.campeonato.mesario.entidades.jpa;


import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
 * Entidade que representa um campeonato.
 *
 * @author andersonvieira
 */
@Entity
@Table(name = "CAMPEONATO")
public class Campeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CAMPEONATO")
    @SequenceGenerator(name = "SEQ_CAMPEONATO", sequenceName = "SEQ_CAMPEONATO", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @Column(name = "DATA_INICIO", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "DATA_FIM", nullable = false)
    private LocalDate dataFim;

    @OneToMany
    @JoinTable(
            name = "CAMPEONATO_TIME",
            joinColumns = @JoinColumn(name = "CAMPEONATO_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "TIME_ID")
    )
    private List<Time> times;

    @OneToOne
    @JoinColumn(name = "CAMPEAO_ID", referencedColumnName = "ID")
    private Time campeao;

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

    public LocalDate getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return this.dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public List<Time> getTimes() {
        return this.times;
    }

    public void setTimes(List<Time> times) {
        this.times = times;
    }

    public Time getCampeao() {
        return this.campeao;
    }

    public void setCampeao(Time campeao) {
        this.campeao = campeao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o instanceof Campeonato that) {
            return Objects.equals(this.id, that.id) &&
                    Objects.equals(this.nome, that.nome) &&
                    Objects.equals(this.dataInicio, that.dataInicio) &&
                    Objects.equals(this.dataFim, that.dataFim) &&
                    Objects.equals(this.times, that.times) &&
                    Objects.equals(this.campeao, that.campeao);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }

}
