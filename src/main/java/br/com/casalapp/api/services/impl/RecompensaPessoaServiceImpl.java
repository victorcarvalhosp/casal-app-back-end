package br.com.casalapp.api.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.casalapp.api.entities.ListaTarefas;
import br.com.casalapp.api.entities.RecompensaPessoa;
import br.com.casalapp.api.repositories.RecompensaPessoaRepository;
import br.com.casalapp.api.services.RecompensaPessoaService;

@Service
public class RecompensaPessoaServiceImpl extends CrudServiceImpl<RecompensaPessoa> implements RecompensaPessoaService {
	
	private static final Logger log = LoggerFactory.getLogger(RecompensaPessoaServiceImpl.class);

	@Autowired
	private RecompensaPessoaRepository repository;
	
	@Override
	public void darRecompensa(ListaTarefas lista) {
		RecompensaPessoa recompensaPessoa = new RecompensaPessoa();
		recompensaPessoa.setPessoa(lista.getCriador().getParceiro());
		recompensaPessoa.setRecompensa(lista.getRecompensa());
		recompensaPessoa.setUtilizado(false);
		repository.save(recompensaPessoa);
	}
	
	@Override
	public Iterable<RecompensaPessoa> buscarRecompensasNaoUtilizadas(Long pessoaId) {
		return repository.buscarRecompensasNaoUtilizadas(pessoaId);
	}

	@Override
	protected CrudRepository<RecompensaPessoa, Long> getRepository() {
		return repository;
	}
	
}
