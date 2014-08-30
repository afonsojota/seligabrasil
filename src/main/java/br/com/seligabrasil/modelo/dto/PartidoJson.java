package br.com.seligabrasil.modelo.dto;

public class PartidoJson {
	private String partidoId;
	private String sigla;
	private Integer quantidadeProcessos = 0;
	
	public PartidoJson(String partidoId, String sigla) {
		super();
		this.partidoId = partidoId;
		this.sigla = sigla;
		this.quantidadeProcessos = 0;
	}
	public PartidoJson() {
		super();
	}
	public String getPartidoId() {
		return partidoId;
	}
	public String getSigla() {
		return sigla;
	}
	public Integer getQuantidadeProcessos() {
		return quantidadeProcessos;
	}
}
