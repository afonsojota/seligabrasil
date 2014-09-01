package br.com.seligabrasil.modelo.repositorio;

import java.util.List;

import br.com.seligabrasil.modelo.dominio.Candidato;
import br.com.seligabrasil.transparenciabrasil.dto.PesquisaCandidato;

public interface Candidatos {

	List<Candidato> pesquisar(PesquisaCandidato filtro);

}
