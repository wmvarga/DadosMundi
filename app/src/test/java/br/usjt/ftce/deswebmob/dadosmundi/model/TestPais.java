package br.usjt.ftce.deswebmob.dadosmundi.model;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author William Morone Varga - RA: 81612389
 * Turma: CCP3AN-MCA / Divisão 1
 */


public class TestPais {

    @Test
    public void testaPais() {
        Pais pais = new Pais();
        pais.setNome("Teste");
        pais.setPopulacao(15);
        pais.setArea(30);

        Pais pais2 = new Pais();
        pais2.setNome("Teste");
        pais2.setPopulacao(15);
        pais2.setArea(30);

        assertEquals(pais.getNome(), pais2.getNome());
        assertEquals(pais.getPopulacao(), pais2.getPopulacao());
        assertEquals(pais.getArea(), pais2.getArea());
    }
}
