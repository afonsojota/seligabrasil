package br.com.seligabrasil.modelo.repositorio;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.seligabrasil.modelo.dao.CargoDao;
import br.com.seligabrasil.modelo.dominio.Cargo;

public class CargosPadrao implements Cargos {
	
	@Inject
	private CargoDao cargoDao;
	
	@Override
	public List<Cargo> recuperaLista() {
		return cargoDao.lista();
	}

	@Transactional
	@Override
	public void armazena(List<Cargo> novaLista) {
		
		for (Cargo cargo : novaLista) {
			cargoDao.salvar(cargo);
		}
		
	}

}
