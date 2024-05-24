package com.organizador.campeonato.mesario.entidades.jpa;


import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


/**
 * Entidade que representa um campo.
 *
 * @author andersonvieira
 */
@Entity
@Table(name = "LOCAL")
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LOCAL")
    @SequenceGenerator(name = "SEQ_LOCAL", sequenceName = "SEQ_LOCAL", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @Column(name = "ENDERECO", nullable = false, length = 300)
    private String endereco;

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

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o instanceof Local that) {
            return Objects.equals(this.id, that.id) &&
                    Objects.equals(this.nome, that.nome) &&
                    Objects.equals(this.endereco, that.endereco);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }

}
