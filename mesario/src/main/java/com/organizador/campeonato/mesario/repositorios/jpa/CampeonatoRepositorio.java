package com.organizador.campeonato.mesario.repositorios.jpa;


import org.springframework.data.jpa.repository.JpaRepository;

import com.organizador.campeonato.mesario.entidades.jpa.Campeonato;


/**
 * Repositório responsável pela entidade {@link Campeonato}.
 *
 * @author andersonvieira
 */
public interface CampeonatoRepositorio extends JpaRepository<Campeonato, Long> {

}
