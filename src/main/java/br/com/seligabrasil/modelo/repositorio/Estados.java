package br.com.seligabrasil.modelo.repositorio;

import java.util.List;

import br.com.seligabrasil.modelo.dominio.Estado;

public interface Estados {
	
	void armazena(List<Estado> estados);
	
	List<Estado> recuperaLista();
	
}
