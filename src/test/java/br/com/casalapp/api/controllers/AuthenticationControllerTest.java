package br.com.casalapp.api.controllers;

import br.com.casalapp.api.entities.Configuracoes;
import br.com.casalapp.api.entities.Pessoa;
import br.com.casalapp.api.security.dto.JwtAuthenticationDto;
import br.com.casalapp.api.services.PessoaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class AuthenticationControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private PessoaService pessoaService;

	@Autowired
	ObjectMapper objectMapper;

	private static final String URL = "/auth/";
	private static final String URL_BUSCAR_EMAIL = URL+ "buscarPorEmail/";


	private static final Long ID = Long.valueOf(1);
	private static final String NOME = "Fulano de tal";
	private static final String EMAIL = "email@email.com";
	private static final String EMAIL_VALIDO = "email@email.com";
	private static final String SENHA_VALIDA = "123456";


	@Before
	public void setUp() throws Exception {

	}

	@After
	public final void tearDown() {
	}


	/*Teste não está funcionando ainda...*/
//	@Test
//	@WithMockUser
//	public void testGerarTokenJwtValido() throws Exception {
//		BDDMockito.given(this.pessoaService.buscarPorEmailESenha(Mockito.anyString(), Mockito.anyString()))
//				.willReturn(Optional.of(this.obterDadosPessoa()));
//		JwtAuthenticationDto dto = new JwtAuthenticationDto();
//		dto.setEmail("email@email.com");
//		dto.setSenha("123456");
//		mvc.perform(MockMvcRequestBuilders.post(URL)
//				.contentType(MediaType.APPLICATION_JSON)
//				.content(objectMapper.writeValueAsString(dto))
//				.accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk())
//				.andExpect(jsonPath("$.data.token").isNotEmpty())
//				.andExpect(jsonPath("$.errors").isEmpty());
//	}

	private Pessoa obterDadosPessoa() {
		return new Pessoa().getPessoaMock();
	}

}
