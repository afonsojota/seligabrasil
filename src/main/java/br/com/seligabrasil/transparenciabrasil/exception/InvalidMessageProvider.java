package br.com.seligabrasil.transparenciabrasil.exception;

public class InvalidMessageProvider implements MessageProvider {

	@Override
	public String getCode() {
		return "-1";
	}

	@Override
	public String getMessage() {
		return "Formato de mensagem não pode ser reconhecida";
	}

}
