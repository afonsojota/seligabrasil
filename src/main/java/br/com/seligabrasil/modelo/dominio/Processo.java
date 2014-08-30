package br.com.seligabrasil.modelo.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Processo {
	
	@Id
	private Integer id;
	private String url;
	
	@ManyToOne
	private Excelencia excelencia;
	
	protected Processo() { }

	public Processo(Integer id, String url, Excelencia excelencia) {
		super();
		this.id = id;
		this.url = url;
		this.excelencia = excelencia;
	}

	public Integer getId() {
		return id;
	}

	public String getUrl() {
		return url;
	}

	public Excelencia getExcelencia() {
		return excelencia;
	}
	
}
