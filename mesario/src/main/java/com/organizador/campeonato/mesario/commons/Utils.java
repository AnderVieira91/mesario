package com.organizador.campeonato.mesario.commons;


import java.text.Normalizer;

import jakarta.annotation.Nullable;


/**
 * Classe responsável pelos métodos utíls do sistema.
 *
 * @author andersonvieira
 */
public class Utils {

    /**
     * Remove todos os acentos de uma {@link String}.
     *
     * @param str
     *          A {@link String} a ter seus acentos removidos.
     *
     * @return
     *         A {@link String} sem acentos.
     */
    public static String removerAcento(@Nullable String str) {
        if (str == null) {
            return null;
        }

        String resultado = Normalizer.normalize(str, Normalizer.Form.NFD);
        resultado = resultado.replaceAll("[^\\p{ASCII}]", "");
        return resultado;
    }

}
