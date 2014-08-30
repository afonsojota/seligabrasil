package br.com.seligabrasil.produtor;

import java.net.URI;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import br.com.caelum.vraptor.environment.Property;
import br.com.seligabrasil.modelo.RestHTTPClient;

@ApplicationScoped
public class ProdutorDoClienteTransparencia {
	
	@Inject @Property("transparencia.uri")
	private String baseURI;
	
	@Inject @Property("transparencia.app.token")
	private String token;
	
	@Inject @Property("transparencia.default.porta")
	private String porta;
	
	@Produces
	public RestHTTPClient getRestHTTPClient() {
		RestHTTPClient client = new RestHTTPClient(URI.create(baseURI));
		
		client.addHeader("App-Token", token);
		client.addHeader("Accept", "application/json");
		
		client.setPort(Integer.parseInt(porta));
		
		return client;
	}
}
