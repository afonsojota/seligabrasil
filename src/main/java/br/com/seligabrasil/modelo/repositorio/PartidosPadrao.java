package br.com.seligabrasil.modelo.repositorio;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.seligabrasil.modelo.dao.PartidoDAO;
import br.com.seligabrasil.modelo.dominio.Partido;

public class PartidosPadrao implements Partidos {

	private PartidoDAO partidoDao;

	@Inject
	public PartidosPadrao(PartidoDAO partidoDao) {
		this.partidoDao = partidoDao;
	}

	@Override
	public List<Partido> recuperaLista() {
		return partidoDao.lista();
	}

	@Override
	@Transactional
	public void armazena(List<Partido> partidos) {
		
		for (Partido partido : partidos) {
			partidoDao.salvar(partido);
		}
	
	}

}