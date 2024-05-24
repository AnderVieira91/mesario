package com.organizador.campeonato.mesario.entidades.jpa;


import java.time.LocalDate;
import java.util.Objects;

import org.hibernate.annotations.NaturalId;

import com.organizador.campeonato.mesario.commons.Utils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


/**
 * Entidade que representa um jogodor.
 *
 * @author andersonvieira
 */
@Entity
@Table(name = "JOGADOR")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_JOGADOR")
    @SequenceGenerator(name = "SEQ_JOGADOR", sequenceName = "SEQ_JOGADOR", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @NaturalId
    @Column(name = "CPF", nullable = false, unique = true)
    private Long cpf;

    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @Column(name = "NOME_NORMALIZADO", nullable = false, length = 100)
    private String nomeNormalizado;

    @Column(name = "APELIDO", length = 60)
    private String apelido;

    @Column(name = "APELIDO_NORMALIZADO", length = 60)
    private String apelidoNormalizado;

    @Column(name = "DATA_NASCIMENTO", nullable = false)
    private LocalDate dataNascimento;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCpf() {
        return this.cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
        this.nomeNormalizado = Utils.removerAcento(this.nome);
    }

    public String getNomeNormalizado() {
        return this.nomeNormalizado;
    }

    public String getApelido() {
        return this.apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
        this.apelidoNormalizado = Utils.removerAcento(this.apelido);
    }

    public String getApelidoNormalizado() {
        return this.apelidoNormalizado;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o instanceof Jogador that) {
            return Objects.equals(this.id, that.id) &&
                    Objects.equals(this.cpf, that.cpf) &&
                    Objects.equals(this.nome, that.nome) &&
                    Objects.equals(this.nomeNormalizado, that.nomeNormalizado) &&
                    Objects.equals(this.apelido, that.apelido) &&
                    Objects.equals(this.apelidoNormalizado, that.apelidoNormalizado) &&
                    Objects.equals(this.dataNascimento, that.dataNascimento);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

}
