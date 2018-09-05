package br.com.casalapp.api.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.casalapp.api.utils.PasswordUtils;

public class PasswordUtilsTest {
	
	private static final String SENHA = "123456";
	private static final String SENHA_INVALIDA = "dsds123456";

	private final BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();

	@Test
	public void testSenhaNula() throws Exception {
		assertNull(PasswordUtils.gerarBCrypt(null));
	}
	
	@Test
	public void compararHashSenhaValidas() throws Exception {
		String hash = PasswordUtils.gerarBCrypt(SENHA);
		System.out.println(hash);
		assertTrue(bCryptEncoder.matches(SENHA, hash));
	}

	@Test
	public void compararHashSenhaInvalidas() throws Exception {
		String hash = PasswordUtils.gerarBCrypt(SENHA_INVALIDA);
		System.out.println(hash);
		assertFalse(bCryptEncoder.matches(SENHA, hash));
	}

}
