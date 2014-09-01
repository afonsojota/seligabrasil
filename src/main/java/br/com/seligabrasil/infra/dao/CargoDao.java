package br.com.seligabrasil.infra.dao;

import java.util.List;

import br.com.seligabrasil.modelo.dominio.Cargo;

public interface CargoDao {

	List<Cargo> lista();
	
	void salvar(Cargo cargo);
}
