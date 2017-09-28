package br.com.casalapp.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.casalapp.api.dtos.RecompensaPessoaDto;
import br.com.casalapp.api.entities.RecompensaPessoa;
import br.com.casalapp.api.mappers.RecompensaPessoaMapper;
import br.com.casalapp.api.response.Response;
import br.com.casalapp.api.services.CrudService;
import br.com.casalapp.api.services.RecompensaPessoaService;

@RestController
@RequestMapping("/recompensas-pessoas")
@CrossOrigin(origins = "*")
public class RecompensaPessoaController extends CrudController<RecompensaPessoa, RecompensaPessoaDto> {

	@Autowired
	private RecompensaPessoaService service;

	@Autowired
	private RecompensaPessoaMapper mapper;

	public RecompensaPessoaController() {
	}

	@GetMapping(value = "/pessoa/conquistados")
	public ResponseEntity<Response<Iterable<RecompensaPessoaDto>>> buscarNaoUtilizados() {
		log.info("Buscando todos os registros");
		Response<Iterable<RecompensaPessoaDto>> response = new Response<Iterable<RecompensaPessoaDto>>();
		Long id = jwtUserDetailsService.getIdPessoaFromHeader();
		Iterable<RecompensaPessoa> list = service.buscarRecompensasNaoUtilizadas(id);

		if (list == null) {
			log.info("Nenhum registro encontrado");
			response.getErrors().add("Nenhum registro encontrado");
			return ResponseEntity.badRequest().body(response);
		}

		List<RecompensaPessoaDto> listDto = new ArrayList<>();
		list.forEach(recompensa -> listDto.add(this.convertEntityToDto(recompensa)));
		response.setData(listDto);
		return ResponseEntity.ok(response);
	}

	@Override
	public CrudService<RecompensaPessoa> getService() {
		return service;
	}

	@Override
	public RecompensaPessoa convertDtoToEntity(RecompensaPessoaDto cadastroDto) {
		return mapper.toEntity(cadastroDto);
	}

	@Override
	public RecompensaPessoaDto convertEntityToDto(RecompensaPessoa entidade) {
		return mapper.toDto(entidade);
	}

}