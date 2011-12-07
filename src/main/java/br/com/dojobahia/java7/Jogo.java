/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dojobahia.java7;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author otavio
 */
class Jogo {

    public static final String COMANDO_ADICIONAR = "adicionar";
    public static final String COMANDO_EMPATE = "empate";
    public static final String COMANDO_ESTAR_JOGANDO = "estar_jogando";
    public static final String COMANDO_INICIAR = "iniciar";
    public static final String COMANDO_PERDEU = "perdeu";
    private List<String> jogadores;
    private List<String> espera;

    
    @SafeVarargs
    public final Object comando(String... comando) {

        switch (comando[0]) {
            case COMANDO_ADICIONAR:
                return acaoAdicionar(comando[1]);

            case COMANDO_INICIAR:
                return jogadores.size()==2;
                
            case COMANDO_PERDEU:
                jogadores.remove(comando[1]);
                acaoSubstituir();
                return true;
                
            case COMANDO_ESTAR_JOGANDO:
                   return jogadores.contains(comando[1]);
                
            case COMANDO_EMPATE:
                jogadores.clear();
                acaoSubstituir();
                acaoSubstituir();
                
            default:
                return null;
        }


    }

    private void acaoSubstituir() {
        jogadores.add(espera.get(0));
        espera.remove(0);
    }

    private Object acaoAdicionar(String complementar) {
        if (jogadores.size() < 2) {
            jogadores.add(complementar);
        }
        else{
        espera.add(complementar);
        }
        return true;
    }

    public Jogo() {
        jogadores = new ArrayList<>();
        espera = new ArrayList<>();
    }

    public int sizeEspera() {
        return espera.size();
    }
}
