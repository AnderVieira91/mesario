package com.organizador.campeonato.mesario.repositorios.jpa;


import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.organizador.campeonato.mesario.entidades.jpa.Jogador;

import jakarta.persistence.EntityManager;


/**
 * Implementação de {@link JogadorRepositorioCustomizado}.
 *
 * @author andersonvieira
 */
public class JogadorRepositorioCustomizadoImpl implements JogadorRepositorioCustomizado {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Jogador buscarPorCpf(Long cpf) {
        Session session = this.entityManager.unwrap(Session.class);
        return session.bySimpleNaturalId(Jogador.class)
                .loadOptional(cpf)
                .orElse(null);
    }

}
