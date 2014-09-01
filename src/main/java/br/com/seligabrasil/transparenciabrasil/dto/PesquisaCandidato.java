package br.com.seligabrasil.transparenciabrasil.dto;

import com.google.common.base.Strings;

public class PesquisaCandidato {
	private String estado;
	private String partido;
	private String cargo;
	private String nomeCandidato;
	
	public static class Builder {
		private String estado;
		private String partido;
		private String cargo;
		private String nomeCandidato;
		
		public Builder(String estado) {
			this.estado = estado;
		}
		
		public Builder partido(String partido) { 
			this.partido = partido; return this;
		}
		
		public Builder cargo(String cargo) {
			this.cargo = cargo; return this;
		}
		
		public Builder nomeCandidato(String nomeCandidato) {
			this.nomeCandidato = nomeCandidato; return this;
		}
		
		public PesquisaCandidato build() {
			if (Strings.isNullOrEmpty(partido) 
				&& Strings.isNullOrEmpty(cargo)
				&& Strings.isNullOrEmpty(nomeCandidato)) {
				throw new IllegalStateException("Faltando parâmetros para pesquisa");
			}
			
			return new PesquisaCandidato(this);
		}
 	}
	
	public PesquisaCandidato(Builder builder) {
		this.estado = builder.estado;
		this.partido = builder.partido;
		this.cargo = builder.cargo;
		this.nomeCandidato = builder.nomeCandidato;
	}

	public String getEstado() {
		return estado;
	}

	public String getPartido() {
		return partido;
	}

	public String getCargo() {
		return cargo;
	}

	public String getNomeCandidato() {
		return nomeCandidato;
	}
	
}
