package br.com.seligabrasil.transparenciabrasil.exception;

public class DefaultMessageProvider implements MessageProvider {

	private String code;
	private String message;
	
	public DefaultMessageProvider(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	@Override
	public String getCode() {
		return code;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

}
