package br.com.casalapp.api.controllers.interfaces.defaults;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.casalapp.api.controllers.PessoaController;
import br.com.casalapp.api.controllers.interfaces.HasDto;
import br.com.casalapp.api.controllers.interfaces.HasService;
import br.com.casalapp.api.dtos.AbstractDto;
import br.com.casalapp.api.entities.AbstractBaseEntity;
import br.com.casalapp.api.response.Response;

public interface DeleteController<T extends AbstractBaseEntity, D extends AbstractDto> extends HasService<T>, HasDto<T, D> {

	public static final Logger log = LoggerFactory.getLogger(PessoaController.class);

	@DeleteMapping(value = "/{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	default public ResponseEntity<Response<String>> remover(@PathVariable("id") Long id) {
		log.info("Removendo lançamento: {}", id);
		Response<String> response = new Response<String>();
		T lancamento = this.getService().findOne(id);

		if (lancamento == null) {
			log.info("Erro ao remover devido ao lançamento ID: {} ser inválido.", id);
			response.getErrors().add("Erro ao remover lançamento. Registro não encontrado para o id " + id);
			return ResponseEntity.badRequest().body(response);
		}

		getService().delete(lancamento);
		return ResponseEntity.ok(new Response<String>());
	}
	
}
