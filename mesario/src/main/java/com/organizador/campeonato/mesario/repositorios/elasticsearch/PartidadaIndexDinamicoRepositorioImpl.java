package com.organizador.campeonato.mesario.repositorios.elasticsearch;


import com.organizador.campeonato.mesario.entidades.elasticsearch.Partida;


/**
 * Implementação do {@link ElasticSearchIndexDinamicoRepositorioImpl} para ser utilizado com a entidade {@link Partida}.
 *
 * @author andersonvieira
 */
public class PartidadaIndexDinamicoRepositorioImpl extends ElasticSearchIndexDinamicoRepositorioImpl<Partida>
        implements PartidadaIndexDinamicoRepositorio {

    @Override
    public Class<Partida> getEntidadeClass() {
        return Partida.class;
    }

    @Override
    public String gerarIndex(Partida partida) {
        if (partida.getCampeonatoId() == null) {
            throw new RuntimeException("É obrigatório informar o id do campeonato da partida");
        }

        return "partida-" + partida.getCampeonatoId();
    }

}
