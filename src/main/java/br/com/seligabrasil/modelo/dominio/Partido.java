package br.com.seligabrasil.modelo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Partido {
	@Id @Column(name = "id")
	private Integer partidoId;
	private String sigla;
	
	public Partido() {
		super();
	}

	public Partido(Integer id, String sigla) {
		this.partidoId = id;
		this.sigla = sigla;
	}

	public Integer getPartidoId() {
		return partidoId;
	}

	public String getSigla() {
		return sigla;
	}

}
