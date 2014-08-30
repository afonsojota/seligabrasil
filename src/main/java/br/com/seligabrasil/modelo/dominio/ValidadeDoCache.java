package br.com.seligabrasil.modelo.dominio;

import java.util.Calendar;

public enum ValidadeDoCache {
	UM_MES(30), UM_DIA(1), INDETERMINADO(-1);
	
	private int quantidade;
	
	private ValidadeDoCache(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public boolean ehUmaDataValida(Calendar dataDoCache) {
		Calendar dataAtual = Calendar.getInstance();

		if (dataDoCache.before(dataAtual)) {
			long diferenca = ((dataAtual.getTimeInMillis() - dataDoCache.getTimeInMillis())) 
					/ (1000 * 60 * 60 * 24);
		
			if (diferenca > quantidade) {
				return false;
			}
			
		}
		
		return true;
	}
}
