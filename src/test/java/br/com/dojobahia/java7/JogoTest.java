/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dojobahia.java7;

import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author otavio
 */
public class JogoTest {

    @Test
    public void iniciadoJogoTest() {

        Jogo jogo = new Jogo();

        jogo.comando("adicionar","Felipe");
        jogo.comando("adicionar","Alex");

        Assert.assertTrue((Boolean)jogo.comando("iniciar",""));


    }
    
     @Test
    public void iniciadoJogoFailTest(){
         Jogo jogo = new Jogo();

        jogo.comando("adicionar","Felipe");
        Assert.assertFalse((Boolean)jogo.comando("iniciar",""));
        
    }

    @Test
    public void estarFileTest(){
    Jogo jogo = new Jogo();

        jogo.comando("adicionar","Felipe");
        jogo.comando("adicionar","Alex");
        jogo.comando("adicionar","Otavio");

        Assert.assertEquals(1, jogo.sizeEspera());
    
    }
    
    
    @Test
    public void estarPerdeuTest(){
    Jogo jogo = new Jogo();

        jogo.comando("adicionar","Felipe");
        jogo.comando("adicionar","Alex");
        jogo.comando("adicionar","Otavio");
        jogo.comando("perdeu","Felipe");

       Assert.assertTrue((Boolean)jogo.comando("estar_jogando","Otavio"));
    
    }
    
    @Test
    public void estarEmpateTest(){
    Jogo jogo = new Jogo();

        jogo.comando("adicionar","Felipe");
        jogo.comando("adicionar","Alex");
        jogo.comando("adicionar","Otavio");
        jogo.comando("adicionar","Bruno");
        
        jogo.comando("empate","");

       Assert.assertTrue((Boolean)jogo.comando("estar_jogando","Bruno"));
    
    }
    
    
    
  
    
   
}
