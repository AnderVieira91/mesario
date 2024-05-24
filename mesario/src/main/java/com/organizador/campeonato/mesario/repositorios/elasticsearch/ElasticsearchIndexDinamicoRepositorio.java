package com.organizador.campeonato.mesario.repositorios.elasticsearch;


/**
 * Interface a ser extendida pelo repositório de uma entidade do Elasticsearch
 * utilize um index gerado de forma dinâmica.
 *
 * @author andersonvieira
 */
public interface ElasticsearchIndexDinamicoRepositorio<T> {

    /**
     * Responsável por salvar uma entidade do Elasticsearch com o index dinâmico.
     *
     * @param entidade
     *              Entidade a ser salva no Elasticsearch.
     *
     * @return
     *              Entidade salva com seu id preenchido.
     */
    T save(T entidade);

}
