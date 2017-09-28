package br.com.casalapp.api.security.services;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface JwtUserDetailsService extends UserDetailsService {

	boolean verificarIdTokenParceiroValido(Long idParceiro);

	boolean verificarIdTokenPessoaValido(Long idPessoa);

	Long getIdParceiroFromHeader();

	Long getIdPessoaFromHeader();

}
