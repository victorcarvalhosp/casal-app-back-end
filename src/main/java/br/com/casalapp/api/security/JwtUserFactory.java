package br.com.casalapp.api.security;


import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.casalapp.api.entities.Pessoa;
import br.com.casalapp.api.enums.PerfilEnum;


public class JwtUserFactory {

	private JwtUserFactory() {
	}

	/**
	 * Converte e gera um JwtUser com base nos dados de uma pessoa.
	 * 
	 * @param pessoa
	 * @return JwtUser
	 */
	public static JwtUser create(Pessoa	 pessoa) {
		Long idParceiro = null;
		if(pessoa.getParceiro() != null) {
			idParceiro = pessoa.getParceiro().getId();
		}
		return new JwtUser(pessoa.getId(), pessoa.getEmail(), pessoa.getSenha(), idParceiro,
				mapToGrantedAuthorities(pessoa.getPerfil()));
	}

	/**
	 * Converte o perfil do usuário para o formato utilizado pelo Spring Security.
	 * 
	 * @param perfilEnum
	 * @return List<GrantedAuthority>
	 */
	private static List<GrantedAuthority> mapToGrantedAuthorities(PerfilEnum perfilEnum) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(perfilEnum.toString()));
		return authorities;
	}

}
