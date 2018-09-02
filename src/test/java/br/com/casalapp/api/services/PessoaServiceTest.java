package br.com.casalapp.api.services;

import br.com.casalapp.api.entities.Pessoa;
import br.com.casalapp.api.repositories.PessoaRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PessoaServiceTest {

	@MockBean
	private PessoaRepository pessoaRepository;

	@Autowired
	private PessoaService pessoaService;

	@Before
	public void setUp() throws Exception {
		BDDMockito.given(this.pessoaRepository.save(Mockito.any(Pessoa.class))).willReturn(new Pessoa());
		BDDMockito.given(this.pessoaRepository.findOne(Mockito.anyLong())).willReturn(new Pessoa());
		BDDMockito.given(this.pessoaRepository.findByEmail(Mockito.anyString())).willReturn(new Pessoa());
	}

	@Test
	public void testPersistirPessoa() {
		Pessoa pessoa = this.pessoaService.save(new Pessoa());

		assertNotNull(pessoa);
	}

	@Test
	public void testBuscarPessoaPorId() {
		Optional<Pessoa> pessoa = this.pessoaService.buscarPorId(1L);

		assertTrue(pessoa.isPresent());
	}

	@Test
	public void testBuscarPessoaPorEmail() {
		Optional<Pessoa> pessoa = this.pessoaService.buscarPorEmail("email@email.com");

		assertTrue(pessoa.isPresent());
	}
	
}
