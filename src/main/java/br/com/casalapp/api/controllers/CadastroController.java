package br.com.casalapp.api.controllers;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.casalapp.api.controllers.interfaces.defaults.PostController;
import br.com.casalapp.api.dtos.CadastroPessoaDto;
import br.com.casalapp.api.entities.Pessoa;
import br.com.casalapp.api.mappers.CadastroPessoaMapper;
import br.com.casalapp.api.response.Response;
import br.com.casalapp.api.services.CrudService;
import br.com.casalapp.api.services.PessoaService;


@RestController
@RequestMapping("/cadastro")
@CrossOrigin(origins = "*")
public class CadastroController implements PostController<Pessoa, CadastroPessoaDto>{

	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private CadastroPessoaMapper mapper;
	
	@Override
	@PostMapping
	public ResponseEntity<Response<CadastroPessoaDto>> cadastrar(@Valid @RequestBody CadastroPessoaDto dto,
			BindingResult result) throws NoSuchAlgorithmException {
		Response<CadastroPessoaDto> response = new Response<CadastroPessoaDto>();

		log.info("Inserindo registro: {}", dto.toString());
		validarDadosExistentes(dto, result);
		if (result.hasErrors()) {
			log.error("Erro validando dados de cadastro PJ: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Pessoa entidade = this.convertDtoToEntity(dto);
		
		getService().save(entidade);
		response.setData(this.convertEntityToDto(entidade));
		return ResponseEntity.ok(response);
	}
	
	private void validarDadosExistentes(CadastroPessoaDto cadastroDto, BindingResult result) {
		this.pessoaService.buscarPorEmail(cadastroDto.getEmail())
				.ifPresent(func -> result.addError(new ObjectError("pessoa", "Email já existente.")));
	}
	

	public CadastroController() {
	}
	
	@Override
	public CadastroPessoaDto convertEntityToDto(Pessoa pessoa) {
		return mapper.toDto(pessoa);
	}

	@Override
	public Pessoa convertDtoToEntity(CadastroPessoaDto dto) {
		return mapper.toEntity(dto);
	}

	@Override
	public CrudService<Pessoa> getService() {
		return pessoaService;
	}
	
	

}