package br.com.casalapp.api.services.impl;

import java.util.Optional;

import br.com.casalapp.api.utils.PasswordUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.casalapp.api.entities.Pessoa;
import br.com.casalapp.api.repositories.PessoaRepository;
import br.com.casalapp.api.security.utils.JwtTokenUtil;
import br.com.casalapp.api.services.PessoaService;


@Service
public class PessoaServiceImpl extends CrudServiceImpl<Pessoa> implements PessoaService {
	
	private static final Logger log = LoggerFactory.getLogger(PessoaServiceImpl.class);

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	public Optional<Pessoa> buscarPorEmail(String email) {
		log.info("Buscando funcionário pelo email {}", email);
		return Optional.ofNullable(this.pessoaRepository.findByEmail(email));
	}

	public Optional<Pessoa> buscarPorEmailESenha(String email, String senha) {
		log.info("Buscando funcionário pelo email {}", email);
		return Optional.ofNullable(this.pessoaRepository.findByEmailAndSenha(email, PasswordUtils.gerarBCrypt(senha)));
	}
	
	@Override
	protected CrudRepository<Pessoa, Long> getRepository() {
		return pessoaRepository;
	}

	@Override
	public Iterable<Pessoa> buscarPedidosPareamento(String email) {
		return pessoaRepository.buscarPedidosPareamento(email);
	}

	@Override
	public Pessoa parear(Long id, Long idParceiro) {
		Pessoa pessoa = pessoaRepository.findOne(id);
		Pessoa parceiro = pessoaRepository.findOne(idParceiro);
		pessoa.setParceiro(parceiro);
		parceiro.setParceiro(pessoa);
		pessoaRepository.save(parceiro);
		return pessoaRepository.save(pessoa);
	}

}