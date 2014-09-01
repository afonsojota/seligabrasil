package br.com.seligabrasil.modelo.dao;

import java.util.List;

import br.com.seligabrasil.modelo.dominio.Partido;

public interface PartidoDAO {
	
	List<Partido> lista();
	
	void salvar(Partido partido);
	
}
