package com.organizador.campeonato.mesario;


import java.io.IOException;

import org.elasticsearch.client.Request;
import org.elasticsearch.client.RestClient;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.indices.DeleteIndexRequest;


@Testcontainers
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ElasticsearchTestes extends BaseTestes {

    @Container
    private static final TestElasticsearchContainer CONTAINER = new TestElasticsearchContainer();

    @Autowired
    private ElasticsearchClient elasticsearchClient;

    @Autowired
    private RestClient restClient;

    @BeforeAll
    public static void start() {
        CONTAINER.start();
    }

    @BeforeAll
    public void beforeAll() throws IOException {
        Request elasticserachRequest = new Request("PUT", "/_cluster/settings");
        elasticserachRequest.setJsonEntity("{ \"persistent\" : { \"action.destructive_requires_name\" : false } }");
        this.restClient.performRequest(elasticserachRequest);
    }

    @BeforeEach
    public void deleteIndex() throws IOException {
        this.elasticsearchClient.indices().delete(DeleteIndexRequest.of(index -> index.index("_all")));
    }

    @AfterAll
    public static void stop() {
        CONTAINER.stop();
    }

}
