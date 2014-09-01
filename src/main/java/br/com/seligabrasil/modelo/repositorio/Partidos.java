package br.com.seligabrasil.modelo.repositorio;

import java.util.List;

import br.com.seligabrasil.modelo.dominio.Partido;

public interface Partidos {

	List<Partido> recuperaLista();
	
	void armazena(List<Partido> partidos);
}
