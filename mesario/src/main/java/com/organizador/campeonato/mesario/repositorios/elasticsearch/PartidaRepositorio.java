package com.organizador.campeonato.mesario.repositorios.elasticsearch;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.organizador.campeonato.mesario.entidades.elasticsearch.Partida;


/**
 * Repositório responsável pela entidade {@link Partida}.
 *
 * @author andersonvieira
 */
public interface PartidaRepositorio extends ElasticsearchRepository<Partida, String>, PartidadaIndexDinamicoRepositorio {

}
