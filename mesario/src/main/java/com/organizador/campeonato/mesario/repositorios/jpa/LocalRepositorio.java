package com.organizador.campeonato.mesario.repositorios.jpa;


import org.springframework.data.jpa.repository.JpaRepository;

import com.organizador.campeonato.mesario.entidades.jpa.Local;


/**
 * Repositório responsável pela entidade {@link Local}.
 *
 * @author andersonvieira
 */
public interface LocalRepositorio extends JpaRepository<Local, Long> {

}
