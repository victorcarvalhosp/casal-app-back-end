package br.com.casalapp.api.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.casalapp.api.dtos.Dto;
import br.com.casalapp.api.entities.AbstractBaseEntity;
import br.com.casalapp.api.response.Response;
import br.com.casalapp.api.services.CrudService;

public abstract class CrudController<T extends AbstractBaseEntity> {
	
	protected static final Logger log = LoggerFactory.getLogger(PessoaController.class);
	
	@PostMapping
	public ResponseEntity<Response<Dto>> cadastrar(@Valid @RequestBody Dto cadastroDto,
			BindingResult result) throws NoSuchAlgorithmException {
		log.info("Cadastrando PF: {}", cadastroDto.toString());
		Response<Dto> response = new Response<Dto>();

		T entidade = this.convertDtoToEntity(cadastroDto);
		
		getService().save(entidade);
		response.setData(this.convertEntityToDto(entidade));
		return ResponseEntity.ok(response);
	}
	
//	@PutMapping(value = "/{id}")
//	public ResponseEntity<Response<Dto>> atualizar(@PathVariable("id") Long id,
//			@Valid @RequestBody Dto dto, BindingResult result) throws NoSuchAlgorithmException {
//		log.info("Atualizando registro: {}", dto.toString());
//		Response<Dto> response = new Response<Dto>();
//
//		Optional<T> pessoa = getService().buscarPorId(id);
//		if (!pessoa.isPresent()) {
//			result.addError(new ObjectError("pessoa", "Pessoa não encontrado."));
//		}
//
//		this.convertDtoToEntity(dto);
//
//		if (result.hasErrors()) {
//			log.error("Erro validando pessoa: {}", result.getAllErrors());
//			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
//			return ResponseEntity.badRequest().body(response);
//		}
//
//		this.pessoaService.persistir(pessoa.get());
//		response.setData(this.convertEntityToDto(pessoa.get()));
//
//		return ResponseEntity.ok(response);
//	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Response<Dto>> buscarPorId(@PathVariable("id") Long id) {
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

	public abstract T convertDtoToEntity(Dto cadastroDto);
	public abstract Dto convertEntityToDto(T entidade);
	
	public abstract CrudService<T> getService();
	
}
