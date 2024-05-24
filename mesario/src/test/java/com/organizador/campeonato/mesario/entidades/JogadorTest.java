package com.organizador.campeonato.mesario.entidades;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Limit;

import com.organizador.campeonato.mesario.BaseTestes;
import com.organizador.campeonato.mesario.entidades.jpa.Jogador;
import com.organizador.campeonato.mesario.repositorios.jpa.JogadorRepositorio;


/**
 * Teste base utilizado mais para testar a configuração do banco.
 *
 * @author andersonvieira
 */
public class JogadorTest extends BaseTestes {

    @Autowired
    private JogadorRepositorio jogadorRepositorio;

    @Test
    public void salvar() {
        Jogador jogador = new Jogador();
        jogador.setCpf(Long.valueOf(111111111L));
        jogador.setNome("nome");
        jogador.setApelido("Móçadâ");
        jogador.setDataNascimento(LocalDate.now());

        jogador = this.jogadorRepositorio.save(jogador);
        assertEquals(1, this.jogadorRepositorio.findAll().size());

        Jogador jogadorPorCpf = this.jogadorRepositorio.buscarPorCpf(jogador.getCpf());
        assertEquals(jogador, jogadorPorCpf);

        Jogador jogadorApelido = this.jogadorRepositorio.buscarJogadorPorTexto("mocada", Limit.of(5)).getFirst();
        assertEquals(jogador, jogadorApelido);
    }

}
