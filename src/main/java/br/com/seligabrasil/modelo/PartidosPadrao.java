package br.com.seligabrasil.modelo;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.seligabrasil.modelo.conversor.ConversorDTODominio;
import br.com.seligabrasil.modelo.dao.PartidoDAO;
import br.com.seligabrasil.modelo.dominio.Partido;
import br.com.seligabrasil.modelo.dto.PartidoJson;
import br.com.seligabrasil.modelo.qualifiers.PartidoConversor;

public class PartidosPadrao implements Partidos {
	private ConversorDTODominio<PartidoJson, Partido> conversor;

	private PartidoDAO partidoDAO;
	
	@Inject @PartidoConversor
	public PartidosPadrao(
		PartidoDAO partidoDAO,
		ConversorDTODominio<PartidoJson, Partido> conversor) {
		
		this.partidoDAO = partidoDAO;
		this.conversor = conversor;
		
	}

	@Transactional
	public List<Partido> getPartidos() {
		List<Partido> partidosDoBD = partidoDAO.getPartidosDoBD();
		
		if (partidosDoBD.isEmpty()) {
			
			PartidoJson[] respostaJson = partidoDAO.getPartidosDoREST();
			
			for (PartidoJson json : respostaJson) {
				Partido partido = conversor.convert(json);
				partidoDAO.salvar(partido);
				partidosDoBD.add(partido);
			}
			
		}
		
		return partidosDoBD;
	}
}
