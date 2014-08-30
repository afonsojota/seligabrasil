package br.com.seligabrasil.modelo.dominio;

import java.util.HashMap;
import java.util.Map;

public enum CasaOpcoes {
	CAMARA_DEPUTADOS(1, "Camara dos Deputados"),
	SENADO_FEDERAL(2, "Senado Federal");
	
	private int codigo;
	private String descricao;
	private static Map<Integer, CasaOpcoes> valueMap = new HashMap<Integer, CasaOpcoes>(2);
	
	static {
		for (CasaOpcoes opt : CasaOpcoes.values()) {
			valueMap.put(opt.getCodigo(), opt);
		}
	}
	
	private CasaOpcoes(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static CasaOpcoes getPorCodigo(Integer codigo) {
		return valueMap.get(codigo);
	}
}
