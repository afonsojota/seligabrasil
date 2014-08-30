package br.com.seligabrasil.modelo.transparenciabrasil.api;

import java.util.List;

import br.com.seligabrasil.modelo.dominio.Bem;
import br.com.seligabrasil.modelo.dominio.Candidato;
import br.com.seligabrasil.modelo.dominio.Candidatura;
import br.com.seligabrasil.modelo.dominio.Doacao;
import br.com.seligabrasil.modelo.dominio.Estado;
import br.com.seligabrasil.modelo.dominio.Estatisticas;

public interface CandidatosRest {

	/**
	 * Retorna uma lista de candidatos. 
	 * É obrigatório definir um estado, exceto quando cargo = 1 (Presidente). 
	 * Além do estado é obrigatório definir um cargo, um partido ou um nome. 
	 * Caso essas condições não estejam satisfeitas a busca retorna uma mensagem de erro.
	 * 
	 * @param estado
	 * @return
	 */
	List<Candidato> getLista(Estado estado);
	
	/**
	 * Retorna informações sobre determinado candidato de acordo com o {id} passado.
	 * 
	 * @param id
	 * @return
	 */
	Candidato getCandidato(String id);
	
	/**
	 * Retorna informações sobre todos os bens declarados pelo candidato, 
	 * separados pelo ano de declaração. 
	 * Contém informações como descrição, tipo e valor unitário do bem declarado.
	 * 
	 * @param idCandidato
	 * @return
	 */
	List<Bem> getBens(String idCandidato);
	
	/**
	 * Para certos cargos, distinguem-se entre doações para o próprio candidato e 
	 * doações para os comitês/diretórios da coligação pela qual o sujeito concorreu; 
	 * Esses casos são identificados por “nome”:“Doações a 
	 * comitês/diretórios da coligação do candidato”,“cgc”:null,“montante”:null
	 * 
	 * @param idCandidato
	 * @param anoEleitoral
	 * @return
	 */
	List<Doacao> getDoacoes(String idCandidato, Integer anoEleitoral);
	
	/**
	 * Informações sobre candidaturas passadas do candidado
	 * 
	 * @param idCandidato
	 * @return
	 */
	List<Candidatura> getCandidaturas(String idCandidato);
	
	/**
	 * Válido apenas para candidatos que estão em exercício na Câmera 
	 * dos Deputados ou no Senado, caso contrário, vazio.
	 * 
	 * @return
	 */
	Estatisticas getEstatisticas(String idCandidato);
}
