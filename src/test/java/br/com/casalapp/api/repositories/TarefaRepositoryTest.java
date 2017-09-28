package br.com.casalapp.api.repositories;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class TarefaRepositoryTest {
	
	private static final String EMAIL = "email@email.com";


	@Autowired
	private TarefaRepository repository;
	
	@Before
	public void setUp() throws Exception {
//		this.repository.save(obterDadosListaTarefas());
	}

	@After
	public final void tearDown() {
		//this.empresaRepository.deleteAll();
	}



}