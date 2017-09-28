package br.com.casalapp.api.security.services.impl;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.casalapp.api.entities.Pessoa;
import br.com.casalapp.api.security.JwtUserFactory;
import br.com.casalapp.api.security.services.JwtUserDetailsService;
import br.com.casalapp.api.security.utils.JwtTokenUtil;
import br.com.casalapp.api.services.PessoaService;


@Service
public class JwtUserDetailsServiceImpl implements JwtUserDetailsService {
	
	private static final String TOKEN_HEADER = "Authorization";
	private static final String BEARER_PREFIX = "Bearer ";

	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private HttpServletRequest request;
	
	@Override
	public boolean verificarIdTokenPessoaValido(Long idPessoa) {
		Long idPessoaToken = jwtTokenUtil.getIdPessoaFromToken(getTokenFromHeader());
		return idPessoa == idPessoaToken;
	}
	
	@Override
	public boolean verificarIdTokenParceiroValido(Long idParceiro) {
		Long idPessoaToken = jwtTokenUtil.getIdPessoaFromToken(getTokenFromHeader());
		return idParceiro == idPessoaToken;
	}

	
	@Override
	public Long getIdParceiroFromHeader() {
		Long idPessoaToken = jwtTokenUtil.getIdParceiroFromToken(getTokenFromHeader());
		return idPessoaToken;
	}
	
	@Override
	public Long getIdPessoaFromHeader() {
		long start = System.nanoTime();    
		Long idPessoaToken = jwtTokenUtil.getIdPessoaFromToken(getTokenFromHeader());
		long elapsedTime = System.nanoTime() - start;
		System.out.println("ELAPSED TIME " + elapsedTime);
		return idPessoaToken;
	}
	
	private String getTokenFromHeader() {
		Optional<String> token = Optional.ofNullable(request.getHeader(TOKEN_HEADER));
		
		if (token.isPresent() && token.get().startsWith(BEARER_PREFIX)) {
			token = Optional.of(token.get().substring(7));
        }
		
//		if (!token.isPresent()) {
//			response.getErrors().add("Token não informado.");
//		} else if (!jwtTokenUtil.tokenValido(token.get())) {
//			response.getErrors().add("Token inválido ou expirado.");
//		}
		return token.get();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Pessoa pessoa = pessoaService.findOne(new Long(username));

		if (pessoa != null) {
			return JwtUserFactory.create(pessoa);
		}

		throw new UsernameNotFoundException("Email não encontrado.");
	}

}