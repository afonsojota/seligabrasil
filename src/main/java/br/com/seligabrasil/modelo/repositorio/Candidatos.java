package br.com.seligabrasil.modelo.repositorio;

import java.util.List;

import br.com.seligabrasil.modelo.dominio.Candidato;
import br.com.seligabrasil.transparenciabrasil.dto.FiltroPesquisaCandidato;

public interface Candidatos {

	List<Candidato> pesquisar(FiltroPesquisaCandidato filtro);

}
