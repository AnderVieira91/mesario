package com.organizador.campeonato.mesario.entidades;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.organizador.campeonato.mesario.ElasticsearchTestes;
import com.organizador.campeonato.mesario.entidades.elasticsearch.Partida;
import com.organizador.campeonato.mesario.repositorios.elasticsearch.PartidaRepositorio;


public class PartidaTest extends ElasticsearchTestes {

    @Autowired
    private PartidaRepositorio partidaRepositorio;

    @Test
    public void salvar() {
        Partida partida = new Partida();
        partida.setCampeonatoId(5L);
        partida.setObservacao("Observação");
        partida.setData(LocalDate.now());
        partida.setTimeMandanteId(1L);
        partida.setTimeVisitanteId(2L);
        partida.setRodada(1);
        partida.setGolsMandante(2);
        partida.setGolsVisitante(0);

        partida = this.partidaRepositorio.save(partida);
        assertTrue(StringUtils.isNotBlank(partida.getId()));
    }

}
