package br.com.casalapp.api.controllers;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.casalapp.api.dtos.Dto;
import br.com.casalapp.api.dtos.PessoaDto;
import br.com.casalapp.api.entities.Pessoa;
import br.com.casalapp.api.response.Response;
import br.com.casalapp.api.services.CrudService;
import br.com.casalapp.api.services.PessoaService;
import br.com.casalapp.api.utils.PasswordUtils;


@RestController
@RequestMapping("/api/pessoas")
@CrossOrigin(origins = "*")
public class PessoaController extends CrudController<Pessoa>{

	@Autowired
	private PessoaService pessoaService;

	public PessoaController() {
	}

	/**
	 * Atualiza os dados de um pessoa.
	 * 
	 * @param id
	 * @param pessoaDto
	 * @param result
	 * @return ResponseEntity<Response<PessoaDto>>
	 * @throws NoSuchAlgorithmException
	 */
//	@PutMapping(value = "/{id}")
//	public ResponseEntity<Response<PessoaDto>> atualizar(@PathVariable("id") Long id,
//			@Valid @RequestBody PessoaDto pessoaDto, BindingResult result) throws NoSuchAlgorithmException {
//		log.info("Atualizando pessoa: {}", pessoaDto.toString());
//		Response<PessoaDto> response = new Response<PessoaDto>();
//
//		Optional<Pessoa> pessoa = this.pessoaService.buscarPorId(id);
//		if (!pessoa.isPresent()) {
//			result.addError(new ObjectError("pessoa", "Pessoa não encontrado."));
//		}
//		
//		this.atualizarDadosPessoa(pessoa.get(), pessoaDto, result);
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

//	/**
//	 * Atualiza os dados do pessoa com base nos dados encontrados no DTO.
//	 * 
//	 * @param pessoa
//	 * @param pessoaDto
//	 * @param result
//	 * @throws NoSuchAlgorithmException
//	 */
//	private void atualizarDadosPessoa(Pessoa pessoa, PessoaDto pessoaDto, BindingResult result)
//			throws NoSuchAlgorithmException {
//		pessoa.setNome(pessoaDto.getNome());
//
//		if (!pessoa.getEmail().equals(pessoaDto.getEmail())) {
//			this.pessoaService.buscarPorEmail(pessoaDto.getEmail())
//					.ifPresent(func -> result.addError(new ObjectError("email", "Email já existente.")));
//			pessoa.setEmail(pessoaDto.getEmail());
//		}
//
//		if (pessoaDto.getSenha().isPresent()) {
//			pessoa.setSenha(PasswordUtils.gerarBCrypt(pessoaDto.getSenha().get()));
//		}
//	}
	
	@GetMapping(value = "/buscarPorEmail/{email}")
	public ResponseEntity<Response<PessoaDto>> buscarPorEmail(@PathVariable("email") String email) {
		log.info("Buscando lançamento por ID: {}", email);
		Response<PessoaDto> response = new Response<PessoaDto>();
		Optional<Pessoa> pessoa = this.pessoaService.buscarPorEmail(email);

		if (!pessoa.isPresent()) {
			log.info("Pessoa não encontrada para o EMAIL: {}", email);
			response.getErrors().add("Pessoa não encontrada para o email " + email);
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(this.convertEntityToDto(pessoa.get()));
		return ResponseEntity.ok(response);
	}

	/**
	 * Retorna um DTO com os dados de um pessoa.
	 * 
	 * @param pessoa
	 * @return PessoaDto
	 */
	@Override
	public PessoaDto convertEntityToDto(Pessoa pessoa) {
		PessoaDto pessoaDto = new PessoaDto();
		pessoaDto.setId(pessoa.getId());
		pessoaDto.setEmail(pessoa.getEmail());
		pessoaDto.setNome(pessoa.getNome());

		return pessoaDto;
	}

	@Override
	public Pessoa convertDtoToEntity(Dto cadastroDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CrudService<Pessoa> getService() {
		// TODO Auto-generated method stub
		return pessoaService;
	}

}