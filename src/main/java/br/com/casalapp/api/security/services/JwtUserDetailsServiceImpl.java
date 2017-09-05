package br.com.casalapp.api.security.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.casalapp.api.entities.Pessoa;
import br.com.casalapp.api.security.JwtUserFactory;
import br.com.casalapp.api.services.PessoaService;


@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private PessoaService pessoaService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Pessoa> pessoa = pessoaService.buscarPorEmail(username);

		if (pessoa.isPresent()) {
			return JwtUserFactory.create(pessoa.get());
		}

		throw new UsernameNotFoundException("Email não encontrado.");
	}

}