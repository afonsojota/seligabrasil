package br.com.seligabrasil.modelo.conversor;

public interface ConversorDTODominio<From, To> {

	To convert(From from);
	
}
