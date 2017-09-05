package br.com.casalapp.api.response;

import java.util.ArrayList;
import java.util.List;

import br.com.casalapp.api.dtos.Dto;

public class Response<T> {

	private Dto data;
	private List<String> errors;

	public Response() {
	}

	public Dto getData() {
		return data;
	}

	public void setData(Dto data) {
		this.data = data;
	}

	public List<String> getErrors() {
		if (this.errors == null) {
			this.errors = new ArrayList<String>();
		}
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}