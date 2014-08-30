package br.com.seligabrasil.modelo.dominio;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Excelencia implements EntidadeDeCache {
	@Id
	private Integer id;

	private String nome;
	private String apelido;
	private String titulo;
	private String cpf;

	@ManyToOne
	private Casa casa;

	@ManyToOne
	private Estado estado;

	@ManyToOne
	private Partido partido;

	@OneToMany
	private List<Processo> processos;

	private String miniBio;
	private String cargos;
	private String bancadas;
	private String partidosPassados;
	private String cargosPassados;
	private String estadosPassados;
	private String municipiosPassados;
	private String votosPassados;
	private String recursosPassados;
	private String resultadosPassados;
	private String anosPassados;

	private Calendar dataCache;

	protected Excelencia() {
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getApelido() {
		return apelido;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getCpf() {
		return cpf;
	}

	public Casa getCasa() {
		return casa;
	}

	public Estado getEstado() {
		return estado;
	}

	public Partido getPartido() {
		return partido;
	}

	public List<Processo> getProcessos() {
		return processos;
	}

	public String getMiniBio() {
		return miniBio;
	}

	public String getCargos() {
		return cargos;
	}

	public String getBancadas() {
		return bancadas;
	}

	public String getPartidosPassados() {
		return partidosPassados;
	}

	public String getCargosPassados() {
		return cargosPassados;
	}

	public String getEstadosPassados() {
		return estadosPassados;
	}

	public String getMunicipiosPassados() {
		return municipiosPassados;
	}

	public String getVotosPassados() {
		return votosPassados;
	}

	public String getRecursosPassados() {
		return recursosPassados;
	}

	public String getResultadosPassados() {
		return resultadosPassados;
	}

	public String getAnosPassados() {
		return anosPassados;
	}

	public Calendar getDataCache() {
		return dataCache;
	}

	@Override
	public boolean ehValida() {
		return ValidadeDoCache.UM_MES.ehUmaDataValida(dataCache);
	}

}
