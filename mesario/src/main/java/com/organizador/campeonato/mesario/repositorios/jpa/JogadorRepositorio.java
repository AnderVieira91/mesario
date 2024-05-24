package com.organizador.campeonato.mesario.repositorios.jpa;


import java.util.List;

import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.organizador.campeonato.mesario.entidades.jpa.Jogador;


/**
 * Repositório responsável pela entidade {@link Jogador}.
 *
 * @author andersonvieira
 */
public interface JogadorRepositorio extends JpaRepository<Jogador, Long>, JogadorRepositorioCustomizado {

    /**
     * Busca todos os {@link Jogador} filtrando por seu nome e apelido.
     *
     * @param texto
     *              Texto a ser utilizado como filtro de busca.
     *
     * @return
     *              Os {@link Jogador} encontrados.
     */
    @Query("""
                SELECT j
                FROM Jogador j
                WHERE
                    LOWER(j.nome) LIKE LOWER(CONCAT('%', :texto,'%'))
                    OR LOWER(j.nomeNormalizado) LIKE LOWER(CONCAT('%', :texto,'%'))
                    OR LOWER(j.apelido) LIKE LOWER(CONCAT('%', :texto,'%'))
                    OR LOWER(j.apelidoNormalizado) LIKE LOWER(CONCAT('%', :texto,'%'))
                ORDER BY
                    j.nome,
                    j.apelido
    """) List<Jogador> buscarJogadorPorTexto(@Param("texto") String texto, Limit limit);

}
