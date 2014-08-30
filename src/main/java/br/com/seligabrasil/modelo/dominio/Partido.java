package br.com.seligabrasil.modelo.dominio;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Partido implements EntidadeDeCache {
	@Id
	private Integer id;
	private String sigla;
	private Calendar dataCache;
	
	public Partido() {
		super();
	}

	public Partido(Integer id, String sigla, Calendar dataCache) {
		super();
		this.id = id;
		this.sigla = sigla;
		this.dataCache = dataCache;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Calendar getDataCache() {
		return dataCache;
	}

	public void setDataCache(Calendar dataCache) {
		this.dataCache = dataCache;
	}

	@Override
	public boolean ehValida() {
		return ValidadeDoCache.UM_MES.ehUmaDataValida(dataCache);
	}
	
}
