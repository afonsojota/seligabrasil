package br.com.seligabrasil.transparenciabrasil.exception;

import com.google.common.base.Optional;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class RespostaIncompativel extends RuntimeException {
	private static final long serialVersionUID = -847510713102202973L;
	private Optional<String> respostaRecebida;
	
	public RespostaIncompativel(Exception e, Optional<String> respostaRecebida) {
		super("Resposta recebida do serviço de transparência não está em conformidade com a estrutura de dados esperada", e);
		this.respostaRecebida = respostaRecebida; 
	}
	
	public Optional<MessageProvider> getMensagemDoProvedor() {
		Gson gson = new Gson();
		MessageProvider message = new InvalidMessageProvider();
		
		try {
			
			if (respostaRecebida.isPresent()) {
				message = gson.fromJson(respostaRecebida.get(), DefaultMessageProvider.class);
			}
			
			return Optional.of(message);
			
		} catch (JsonSyntaxException e) {
			return Optional.of(message);
		}
	}
	
}
