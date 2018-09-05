package br.com.casalapp.api.repositories;

import static org.junit.Assert.assertEquals;

import java.security.NoSuchAlgorithmException;

import br.com.casalapp.api.entities.Configuracoes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.casalapp.api.entities.Pessoa;
import br.com.casalapp.api.enums.PerfilEnum;
import br.com.casalapp.api.utils.PasswordUtils;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PessoaRepositoryTest {

	@Autowired
	private PessoaRepository pessoaRepository;

	private static final String EMAIL = "email@email.com";

	@Before
	public void setUp() throws Exception {
		this.pessoaRepository.save(obterDadosPessoa());
	}

	@After
	public final void tearDown() {
		this.pessoaRepository.deleteAll();
	}

	@Test
	public void testBuscarPessoaPorEmail() {
		Pessoa pessoa = this.pessoaRepository.findByEmail(EMAIL);
		assertEquals(EMAIL, pessoa.getEmail());
	}

	private Pessoa obterDadosPessoa() throws NoSuchAlgorithmException {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Fulano de Tal");
		pessoa.setPerfil(PerfilEnum.ROLE_USUARIO);
		pessoa.setSenha(PasswordUtils.gerarBCrypt("123456"));
		pessoa.setEmail(EMAIL);
		Configuracoes config = new Configuracoes();
		config.setPessoa(pessoa);
		pessoa.setConfiguracoes(config);
		return pessoa;
	}


}