package com.organizador.campeonato.mesario;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan("com.organizador.campeonato.mesario.entidades.jpa")
@EnableElasticsearchRepositories("com.organizador.campeonato.mesario.repositorios.elasticsearch")
@EnableJpaRepositories("com.organizador.campeonato.mesario.repositorios.jpa")
public class MesarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MesarioApplication.class, args);
	}

}
