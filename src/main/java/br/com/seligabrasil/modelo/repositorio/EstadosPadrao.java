package br.com.seligabrasil.modelo.repositorio;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.seligabrasil.modelo.dao.EstadoDAO;
import br.com.seligabrasil.modelo.dominio.Estado;

public class EstadosPadrao implements Estados {
	
	private EstadoDAO dao;

	@Inject
	public EstadosPadrao(EstadoDAO dao) {
		this.dao = dao;
	}

	@Override
	@Transactional
	public void armazena(List<Estado> estados) {
		
		for (Estado estado : estados) {
			dao.insere(estado);
		}
		
	}

	@Override
	public List<Estado> recuperaLista() {
		return dao.lista();
	}

}
