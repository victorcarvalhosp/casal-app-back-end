package br.com.casalapp.api.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.casalapp.api.dtos.ParearDto;
import br.com.casalapp.api.dtos.PessoaDto;
import br.com.casalapp.api.entities.Pessoa;
import br.com.casalapp.api.mappers.PessoaMapper;
import br.com.casalapp.api.response.Response;
import br.com.casalapp.api.services.CrudService;
import br.com.casalapp.api.services.PessoaService;


@RestController
@RequestMapping("/pessoas")
@CrossOrigin(origins = "*")
public class PessoaController extends CrudController<Pessoa, PessoaDto>{

	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private PessoaMapper pessoaMapper;
	

	public PessoaController() {
	}
	
	
	@PostMapping(value="/parear")
	public ResponseEntity<Response<PessoaDto>> parear(@Valid @RequestBody ParearDto dto,
			BindingResult result) throws NoSuchAlgorithmException {
		Response<PessoaDto> response = new Response<PessoaDto>();

		Pessoa entidade = pessoaService.parear(dto.getId(), dto.getIdParceiro());
		
		response.setData(this.convertEntityToDto(entidade));
		return ResponseEntity.ok(response);
	}

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
	
	@GetMapping(value = "/pedidos-pareamento/{email}")
	public ResponseEntity<Response<Iterable<PessoaDto>>> buscarPedidosPareamento(@PathVariable("email") String email) {
		log.info("Buscando todos os registros");
		Response<Iterable<PessoaDto>> response = new Response<Iterable<PessoaDto>>();
		Iterable<Pessoa> list = pessoaService.buscarPedidosPareamento(email);

		if (list == null) {
			log.info("Nenhum registro encontrado");
			response.getErrors().add("Nenhum registro encontrado");
			return ResponseEntity.badRequest().body(response);
		}

		List<PessoaDto> listDto = new ArrayList<>();
		list.forEach(lancamento -> listDto.add(this.convertEntityToDto(lancamento)));
		response.setData(listDto);
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
		return pessoaMapper.toDto(pessoa);
	}

	@Override
	public Pessoa convertDtoToEntity(PessoaDto dto) {
		return pessoaMapper.toEntity(dto);
	}

	@Override
	public CrudService<Pessoa> getService() {
		return pessoaService;
	}
	
	

}