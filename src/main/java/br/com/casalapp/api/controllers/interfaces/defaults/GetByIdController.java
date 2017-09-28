package br.com.casalapp.api.controllers.interfaces.defaults;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.casalapp.api.controllers.PessoaController;
import br.com.casalapp.api.controllers.interfaces.HasDto;
import br.com.casalapp.api.controllers.interfaces.HasService;
import br.com.casalapp.api.dtos.AbstractDto;
import br.com.casalapp.api.dtos.Dto;
import br.com.casalapp.api.entities.AbstractBaseEntity;
import br.com.casalapp.api.response.Response;

public interface GetByIdController<T extends AbstractBaseEntity, D extends AbstractDto> extends HasService<T>, HasDto<T, D> {

	public static final Logger log = LoggerFactory.getLogger(PessoaController.class);


	@GetMapping(value = "/{id}")
	default public ResponseEntity<Response<Dto>> buscarPorId(@PathVariable("id") Long id) {
		log.info("Buscando por ID: {}", id);
		Response<Dto> response = new Response<Dto>();
		Optional<T> entidade = getService().buscarPorId(id);

		if (!entidade.isPresent()) {
			log.info("entidade não encontrada para o ID: {}", id);
			response.getErrors().add("Registro não encontrado para o id " + id);
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(this.convertEntityToDto(entidade.get()));
		return ResponseEntity.ok(response);
	}
}
