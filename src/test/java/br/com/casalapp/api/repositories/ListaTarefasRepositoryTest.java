package br.com.casalapp.api.repositories;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.casalapp.api.entities.ListaTarefas;
import br.com.casalapp.api.entities.Pessoa;
import br.com.casalapp.api.entities.Tarefa;
import br.com.casalapp.api.enums.PerfilEnum;
import br.com.casalapp.api.enums.TipoListaEnum;
import io.jsonwebtoken.lang.Assert;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ListaTarefasRepositoryTest {
	
	private static final String EMAIL = "email@email.com";


	@Autowired
	private ListaTarefasRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Before
	public void setUp() throws Exception {
//		this.repository.save(obterDadosListaTarefas());
	}

	@After
	public final void tearDown() {
		//this.empresaRepository.deleteAll();
	}

	@Test
	public void testSave() {
		this.repository.save(obterDadosListaTarefas());

		Assert.notNull(repository.findAll());
	}

	private ListaTarefas obterDadosListaTarefas() {
		ListaTarefas listaTarefas = new ListaTarefas();
		listaTarefas.setTitulo("Titulo");
		cadastrarPessoa();
		Pessoa criador = pessoaRepository.findByEmail(EMAIL);
		listaTarefas.setCriador(criador);
		listaTarefas.setModelo(false);
		listaTarefas.setTipo(TipoListaEnum.LOUCA);
		List<Tarefa> tarefas = new ArrayList<>();
		for (int i = 1; i <= 3; i++) {
			Tarefa tarefa = new Tarefa();
			tarefa.setTitulo("Tarefa " + i);
			tarefa.setLista(listaTarefas);
			tarefas.add(tarefa);
		}
		listaTarefas.setTarefas(tarefas);
		
		return listaTarefas;
	}

	private void cadastrarPessoa() {
		Pessoa criador = new Pessoa();
		criador.setEmail(EMAIL);
		criador.setNome("Nome");
		criador.setPerfil(PerfilEnum.ROLE_USUARIO);
		criador.setSenha("123456");
		pessoaRepository.save(criador);
	}


}