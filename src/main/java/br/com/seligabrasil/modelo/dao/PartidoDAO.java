package br.com.seligabrasil.modelo.dao;

import java.util.List;

import br.com.seligabrasil.modelo.dominio.Partido;
import br.com.seligabrasil.modelo.dto.PartidoJson;

public interface PartidoDAO {
	
	List<Partido> getPartidosDoBD();
	
	PartidoJson[] getPartidosDoREST();
	
	void salvar(Partido partido);
	
}
