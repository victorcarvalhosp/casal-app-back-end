package br.com.casalapp.api.controllers.interfaces.defaults;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.casalapp.api.controllers.PessoaController;
import br.com.casalapp.api.controllers.interfaces.HasDto;
import br.com.casalapp.api.controllers.interfaces.HasService;
import br.com.casalapp.api.dtos.AbstractDto;
import br.com.casalapp.api.dtos.Dto;
import br.com.casalapp.api.entities.AbstractBaseEntity;
import br.com.casalapp.api.response.Response;

public interface GetController<T extends AbstractBaseEntity, D extends AbstractDto> extends HasService<T>, HasDto<T, D> {

	public static final Logger log = LoggerFactory.getLogger(PessoaController.class);


	@GetMapping
	default public ResponseEntity<Response<Iterable<Dto>>> buscarTodos() {
		log.info("Buscando todos os registros");
		Response<Iterable<Dto>> response = new Response<Iterable<Dto>>();
		Iterable<T> list = getService().findAll();

		if (list == null) {
			log.info("Nenhum registro encontrado");
			response.getErrors().add("Nenhum registro encontrado");
			return ResponseEntity.badRequest().body(response);
		}

		List<Dto> listDto = new ArrayList<>();
		list.forEach(lancamento -> listDto.add(this.convertEntityToDto(lancamento)));
		response.setData(listDto);
		return ResponseEntity.ok(response);
	}
}
