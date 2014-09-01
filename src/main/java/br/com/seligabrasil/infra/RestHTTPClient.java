package br.com.seligabrasil.infra;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.enterprise.inject.Vetoed;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;

import br.com.seligabrasil.transparenciabrasil.exception.ServidorIndisponivelException;

/**
 * Wrapper para HttpClient para facilitar as chamadas REST de maneira fluida.
 * Essa classe está declarada como Vetoed pois deve ser criada através de um produtor
 * que garanta as configurações básicas como uri, porta, e outras configurações padrão.
 * 
 * @author hastronauta
 */
@Vetoed
public class RestHTTPClient {
	private URI baseURI;
	private int port;
	private HttpClient httpClient = new HttpClient();
	private Set<Header> headers = new HashSet<>();
	private Map<String, String> parameters = new HashMap<>();
	
	public RestHTTPClient() {
		this(null);
	}
	
	public RestHTTPClient(URI baseURI) {
		this.baseURI = baseURI;
	}
	
	public RestHTTPClient addHeader(String name, String value) {
		Header h = new Header(name, value);
		headers.add(h);
		return this;
	}

	public RestHTTPClient setPort(int port) {
		this.port = port;
		return this;
	}
	
	public String get(String resource) {

		GetMethod httpMethod = new GetMethod(baseURI + ":" + port + resource);
		for (Header header : headers) {
			httpMethod.addRequestHeader(header);
		}
		
		List<NameValuePair> params = new ArrayList<>();
		for (String key : parameters.keySet()) {
			params.add(new NameValuePair(key, parameters.get(key)));
		}
		
		httpMethod.setQueryString(params.toArray(new NameValuePair[]{}));
		
		try {
			
			httpClient.executeMethod(httpMethod);
			return httpMethod.getResponseBodyAsString();
			
		} catch (HttpException e) {
			// TODO - melhorar esse tratamento 
			throw new RuntimeException(e);
			
		} catch (IOException e) {
			throw new ServidorIndisponivelException(e);
			
		} finally {
			
			if (httpMethod != null) {
				httpMethod.releaseConnection();
			}
			
		}
		
	}

	public RestHTTPClient addParameter(String name, String value) {
		parameters.put(name, value);
		return this;
	}

	public RestHTTPClient addParameter(String name, int value) {
		parameters.put(name, Integer.toString(value));
		return this;
	}
}
