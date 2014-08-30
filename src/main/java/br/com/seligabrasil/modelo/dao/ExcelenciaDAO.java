package br.com.seligabrasil.modelo.dao;

import br.com.seligabrasil.modelo.dominio.CasaOpcoes;
import br.com.seligabrasil.modelo.dto.ExcelenciaJson;

public interface ExcelenciaDAO {
	ExcelenciaJson[] getExcelencias(CasaOpcoes casa, String partidoId);
}
