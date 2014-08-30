package br.com.seligabrasil.modelo.dao.rest;

import javax.inject.Inject;

import br.com.seligabrasil.modelo.RestHTTPClient;
import br.com.seligabrasil.modelo.dao.ExcelenciaDAO;
import br.com.seligabrasil.modelo.dominio.CasaOpcoes;
import br.com.seligabrasil.modelo.dto.ExcelenciaJson;

import com.google.gson.Gson;

public class ExcelenciaDAORest implements ExcelenciaDAO {

	private RestHTTPClient rest;
	
	@Inject
	public ExcelenciaDAORest(RestHTTPClient rest) {
		this.rest = rest;
	}
	
	@Deprecated
	public ExcelenciaDAORest() {
		this(null);
	}

	@Override
	public ExcelenciaJson[] getExcelencias(CasaOpcoes casa, String partidoId) {
		String excelencias = rest
			.addParameter("casa", casa.getCodigo())
			.addParameter("partidoId", partidoId)
			.get("/sandbox/v1/excelencias");
		
		Gson gson = new Gson();
		return gson.fromJson(excelencias, ExcelenciaJson[].class);
	}

}
