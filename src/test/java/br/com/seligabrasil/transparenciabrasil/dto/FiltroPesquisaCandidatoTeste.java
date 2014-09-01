package br.com.seligabrasil.transparenciabrasil.dto;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FiltroPesquisaCandidatoTeste {
	
	@Test
	public void shouldBeAMapWithSizeEqualsToFiveIfAllParametersFilled() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		
		when(request.getParameter("estado")).thenReturn("SP");
		when(request.getParameter("partido")).thenReturn("1");
		when(request.getParameter("nomeCandidato")).thenReturn("TIRIRICA");
		when(request.getParameter("cargo")).thenReturn("1");
		
		FiltroPesquisaCandidato filtro = new FiltroPesquisaCandidato(request);
		assertEquals(4, filtro.getParametros().size());
		
	}

}
