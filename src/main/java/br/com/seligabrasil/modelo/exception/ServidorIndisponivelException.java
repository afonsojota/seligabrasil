package br.com.seligabrasil.modelo.exception;

public class ServidorIndisponivelException extends RuntimeException {
	private static final long serialVersionUID = -5280072666851554415L;

	public ServidorIndisponivelException(Throwable e) {
		super("Não foi possível acessar o servidor", e);
	}
}
