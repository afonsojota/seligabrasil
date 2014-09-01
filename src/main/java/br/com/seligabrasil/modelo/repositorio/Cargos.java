package br.com.seligabrasil.modelo.repositorio;

import java.util.List;

import br.com.seligabrasil.modelo.dominio.Cargo;

public interface Cargos {

	List<Cargo> recuperaLista();

	void armazena(List<Cargo> novaLista);

}
