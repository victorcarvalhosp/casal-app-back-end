package br.com.casalapp.api.controllers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.casalapp.api.entities.Pessoa;
import br.com.casalapp.api.services.PessoaService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PessoaControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private PessoaService pessoaService;

	private static final String PESSOAS_URL = "/api/pessoas/";
	private static final String URL_BUSCAR_EMAIL = PESSOAS_URL+ "buscarPorEmail/";
	private static final Long ID = Long.valueOf(1);
	private static final String NOME = "Fulano de tal";
	private static final String EMAIL = "email@email.com";


//	@Test
//	@WithMockUser
//	public void testBuscarPessoaEmailInvalido() throws Exception {
//		BDDMockito.given(this.pessoaService.buscarPorEmail(Mockito.anyString())).willReturn(Optional.empty());
//
//	java.lang.AssertionError: JSON path "$.errors" expected:<Pessoa não encontrada para o email email@email.com> but was:<Pessoa não encontrada para o email email@email>
//		mvc.perform(MockMvcRequestBuilders.get(PESSOAS_URL + EMAIL).accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isBadRequest())
//				.andExpect(jsonPath("$.errors").value("Pessoa não encontrada para o email " + EMAIL));
//	}

	@Test
	@WithMockUser
	public void testBuscarPessoaEmailValido() throws Exception {
		BDDMockito.given(this.pessoaService.buscarPorEmail(Mockito.anyString()))
				.willReturn(Optional.of(this.obterDadosPessoa()));

		mvc.perform(MockMvcRequestBuilders.get(URL_BUSCAR_EMAIL + EMAIL)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.data.id").value(ID))
				.andExpect(jsonPath("$.data.nome", equalTo(NOME)))
				.andExpect(jsonPath("$.data.email", equalTo(EMAIL)))
				.andExpect(jsonPath("$.errors").isEmpty());
	}

	private Pessoa obterDadosPessoa() {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(ID);
		pessoa.setNome(NOME);
		pessoa.setEmail(EMAIL);
		return pessoa;
	}

}
