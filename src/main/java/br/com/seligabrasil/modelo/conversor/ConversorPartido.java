package br.com.seligabrasil.modelo.conversor;

import java.util.Calendar;

import br.com.seligabrasil.modelo.dominio.Partido;
import br.com.seligabrasil.modelo.dto.PartidoJson;

public class ConversorPartido implements ConversorDTODominio<PartidoJson, Partido>{

	@Override
	public Partido convert(PartidoJson json) {
		Partido partido = new Partido();
		
		partido.setId(Integer.valueOf(json.getPartidoId()));
		partido.setDataCache(Calendar.getInstance());
		partido.setSigla(json.getSigla());
		
		return partido;
	}

}
