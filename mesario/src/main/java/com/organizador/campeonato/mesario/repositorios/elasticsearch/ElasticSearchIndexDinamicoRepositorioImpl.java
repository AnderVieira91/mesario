package com.organizador.campeonato.mesario.repositorios.elasticsearch;


import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;


/**
 * Implementação abstrata de {@link ElasticsearchIndexDinamicoRepositorio}.
 *
 * @author andersonvieira
 */
public abstract class ElasticSearchIndexDinamicoRepositorioImpl<T> implements ElasticsearchIndexDinamicoRepositorio<T> {

    private final ConcurrentHashMap<String, IndexCoordinates> indexCoordinatesMap = new ConcurrentHashMap<>();

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Nullable
    private Document mapping;

    public abstract Class<T> getEntidadeClass();
    public abstract String gerarIndex(T entidade);

    /**
     * Responsável por salvar uma entidade do Elasticsearch com o index dinâmico.
     *
     * @param entidade
     *              Entidade a ser salva no Elasticsearch.
     *
     * @return
     *              Entidade salva com seu id preenchido.
     */
    @Override
    public T save(T entidade) {
        IndexCoordinates indexCoordinates = this.getIndexCoordinates(entidade);
        T saved = this.elasticsearchOperations.save(entidade, indexCoordinates);
        this.elasticsearchOperations.indexOps(indexCoordinates).refresh();

        return saved;
    }

    /**
     * Obtêm o {@link IndexCoordinates} a ser utilizado para informa o index da entidade a ser salva.
     *
     * @param entidade
     *              Entidade a ser utilizada para obter o {@link IndexCoordinates}.
     *
     * @return
     *              {@link IndexCoordinates} obtido.
     */
    @NonNull
    private IndexCoordinates getIndexCoordinates(T entidade) {
        String indexName = this.gerarIndex(entidade);

        return this.indexCoordinatesMap.computeIfAbsent(indexName, i -> {
                    IndexCoordinates indexCoordinates = IndexCoordinates.of(i);
                    IndexOperations indexOps = this.elasticsearchOperations.indexOps(indexCoordinates);

                    if (!indexOps.exists()) {
                        indexOps.create();

                        if (this.mapping == null) {
                            this.mapping = indexOps.createMapping(this.getEntidadeClass());
                        }

                        indexOps.putMapping(this.mapping);
                    }

                    return indexCoordinates;
                }
        );
    }

}
