package br.com.seligabrasil.modelo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cargo {
	@Id @Column(name="id")
	private Integer cargoId;
	private String nome;

	public Cargo() {
	}

	public Cargo(Integer cargoId, String nome) {
		this.cargoId = cargoId;
		this.nome = nome;
	}

	public Integer getCargoId() {
		return cargoId;
	}

	public String getNome() {
		return nome;
	}
	
}
