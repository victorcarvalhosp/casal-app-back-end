package br.com.casalapp.api.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.com.casalapp.api.entities.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long>{
	
	@Transactional(readOnly = true)
	Pessoa findByEmailAndSenha(String email, String senha);

	@Transactional(readOnly = true)
	Pessoa findByEmail(String email);
	
	@Query("SELECT p FROM Pessoa p WHERE lower(p.configuracoes.emailParceiroConvite) LIKE lower(concat('%', :email,'%'))")
	Iterable<Pessoa> buscarPedidosPareamento(@Param("email") String email);
	
}
