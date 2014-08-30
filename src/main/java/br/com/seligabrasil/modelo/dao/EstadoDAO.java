package br.com.seligabrasil.modelo.dao;

import java.util.List;

import br.com.seligabrasil.modelo.dominio.Estado;

public interface EstadoDAO {
	
	List<Estado> lista();

	Long insere(Estado estado);
	
}
