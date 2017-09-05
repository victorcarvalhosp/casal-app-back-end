package br.com.casalapp.api.security.dto;

import br.com.casalapp.api.dtos.Dto;

public class TokenDto implements Dto {

	private String token; 
	
	public TokenDto() {
	}
	
	public TokenDto(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}