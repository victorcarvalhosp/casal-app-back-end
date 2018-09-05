package br.com.casalapp.api.services;

import br.com.casalapp.api.entities.Configuracoes;
import br.com.casalapp.api.entities.Pessoa;
import br.com.casalapp.api.enums.PerfilEnum;
import br.com.casalapp.api.repositories.PessoaRepository;
import br.com.casalapp.api.utils.PasswordUtils;
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

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PessoaServiceTest {

	public static final String EMAIL_VALIDO = "email@email.com";
	@MockBean
	private PessoaRepository pessoaRepository;

	@Autowired
	private PessoaService pessoaService;

	@Before
	public void setUp() throws Exception {
		BDDMockito.given(this.pessoaRepository.save(Mockito.any(Pessoa.class))).willReturn(obterDadosPessoa());
		BDDMockito.given(this.pessoaRepository.findOne(Mockito.anyLong())).willReturn(obterDadosPessoa());
		BDDMockito.given(this.pessoaRepository.findByEmail("email@email.com")).willReturn(obterDadosPessoa());
		BDDMockito.given(this.pessoaRepository.findByEmail("email@email.co222m")).willReturn(null);
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

	@Test
	public void testBuscarPessoaPorEmailESenhaValidos() {
		Optional<Pessoa> pessoa = this.pessoaService.buscarPorEmailESenha("email@email.com", "123456");
		assertTrue(pessoa.isPresent());
	}

	@Test
	public void testBuscarPessoaPorEmailESenhaInvalida() {
		Optional<Pessoa> pessoa = this.pessoaService.buscarPorEmailESenha("email@email.com", "dsds123456");
		assertTrue(!pessoa.isPresent());
	}

	@Test
	public void testBuscarPessoaPorEmailInvalidoESenhaValida() {
		Optional<Pessoa> pessoa = this.pessoaService.buscarPorEmailESenha("email@email.co222m", "123456");
		assertTrue(!pessoa.isPresent());
	}

	private Pessoa obterDadosPessoa() throws NoSuchAlgorithmException {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Fulano de Tal");
		pessoa.setPerfil(PerfilEnum.ROLE_USUARIO);
		pessoa.setSenha(PasswordUtils.gerarBCrypt("123456"));
		pessoa.setEmail(EMAIL_VALIDO);
		Configuracoes config = new Configuracoes();
		config.setId(Long.valueOf(1));
		pessoa.setConfiguracoes(config);
		return pessoa;
	}
	
}
