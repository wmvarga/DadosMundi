package br.usjt.ftce.deswebmob.dadosmundi.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.usjt.ftce.deswebmob.dadosmundi.model.Pais;
import br.usjt.ftce.deswebmob.dadosmundi.view.DetalhePaisView;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author William Morone Varga - RA: 81612389
 * Turma: CCP3AN-MCA / Divisão 1
 */

@RunWith(MockitoJUnitRunner.class)
public class TestDetalhePaisPresenter {
    private DetalhePaisPresenter presenter;

    @Mock
    private DetalhePaisView view;

    @Before
    public void setup() {
        presenter = new DetalhePaisPresenter(view);
    }

    @Test
    public void testeMostrar(){
        Pais pais = new Pais();
        pais.setNome("País de Teste");
        presenter.mostrar(pais);
        when(view.getPais()).thenReturn(pais);
        assertEquals(pais,view.getPais());
    }
}
