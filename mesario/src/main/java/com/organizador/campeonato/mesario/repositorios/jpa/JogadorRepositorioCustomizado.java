package com.organizador.campeonato.mesario.repositorios.jpa;


import com.organizador.campeonato.mesario.entidades.jpa.Jogador;


/**
 * Interface criada para podermos fazer queries da entidade {@link Jogador} usando o NaturalId.
 *
 * @author andersonvieira
 */
public interface JogadorRepositorioCustomizado {

    /**
     * Procura um {@link Jogador} através de seu cpf, olhando o cache do hibernate.
     *
     * @param cpf
     *          O cpf do {@link Jogador} desejado.
     *
     * @return
     *          O {@link Jogador} encontrado.
     */
    Jogador buscarPorCpf(Long cpf);

}
