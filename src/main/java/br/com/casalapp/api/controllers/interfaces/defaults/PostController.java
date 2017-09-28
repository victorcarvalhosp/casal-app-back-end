package br.com.casalapp.api.controllers.interfaces.defaults;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.casalapp.api.controllers.PessoaController;
import br.com.casalapp.api.controllers.interfaces.HasDto;
import br.com.casalapp.api.controllers.interfaces.HasService;
import br.com.casalapp.api.dtos.AbstractDto;
import br.com.casalapp.api.entities.AbstractBaseEntity;
import br.com.casalapp.api.response.Response;

public interface PostController<T extends AbstractBaseEntity, D extends AbstractDto> extends HasService<T>, HasDto<T, D> {

	public static final Logger log = LoggerFactory.getLogger(PessoaController.class);

	@PostMapping
	default 
	public ResponseEntity<Response<D>> cadastrar(@Valid @RequestBody D dto,
			BindingResult result) throws NoSuchAlgorithmException {
		Response<D> response = new Response<D>();

		log.info("Inserindo registro: {}", dto.toString());

		T entidade = this.convertDtoToEntity(dto);
		
		getService().save(entidade);
		response.setData(this.convertEntityToDto(entidade));
		return ResponseEntity.ok(response);
	}
	
}
