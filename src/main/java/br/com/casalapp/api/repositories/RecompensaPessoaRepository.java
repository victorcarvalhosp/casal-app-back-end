package br.com.casalapp.api.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.casalapp.api.entities.RecompensaPessoa;

public interface RecompensaPessoaRepository extends CrudRepository<RecompensaPessoa, Long>{
	
	@Query("SELECT r FROM RecompensaPessoa r WHERE r.pessoa.id  = :pessoaId AND r.utilizado = false ORDER BY r.id ")
	Iterable<RecompensaPessoa> buscarRecompensasNaoUtilizadas(@Param("pessoaId") Long pessoaId);

}
