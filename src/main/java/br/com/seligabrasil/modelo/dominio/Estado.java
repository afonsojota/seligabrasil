package br.com.seligabrasil.modelo.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Estado {
	
	@Id
	private Long estadoId;
	private String sigla;
	private String nome;
	
	protected Estado() { }
	
	public Estado(Long estadoId, String sigla, String nome) {
		this.estadoId = estadoId;
		this.sigla = sigla;
		this.nome = nome;
	}
	
	public Long getId() {
		return estadoId;
	}

	public String getSigla() {
		return sigla;
	}

	public String getNome() {
		return nome;
	}

}
