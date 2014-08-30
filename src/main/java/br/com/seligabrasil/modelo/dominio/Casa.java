package br.com.seligabrasil.modelo.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Casa {
	@Id
	private Integer codigo;
	private String descricao;
	
	public Casa(Integer codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	protected Casa() { }

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
}