package br.com.casalapp.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.casalapp.api.dtos.RecompensaDto;
import br.com.casalapp.api.dtos.RecompensaPessoaDto;
import br.com.casalapp.api.entities.Recompensa;
import br.com.casalapp.api.mappers.RecompensaMapper;
import br.com.casalapp.api.response.Response;
import br.com.casalapp.api.services.RecompensaService;


@RestController
@RequestMapping("/recompensas")
@CrossOrigin(origins = "*")
public class RecompensaController extends CrudController<Recompensa, RecompensaDto>{

	@Autowired
	private RecompensaService recompensaService;
	
	@Autowired
	private RecompensaMapper recompensaMapper;
	

	public RecompensaController() {
	}
	
	@GetMapping(value="/modelos")
	public ResponseEntity<Response<Iterable<RecompensaDto>>> buscarModelos() {
		log.info("Buscando todos os registros");
		Response<Iterable<RecompensaDto>> response = new Response<Iterable<RecompensaDto>>();
		Iterable<Recompensa> list = getService().buscarModelos();
		if (list == null) {
			log.info("Nenhum registro encontrado");
			response.getErrors().add("Nenhum registro encontrado");
			return ResponseEntity.badRequest().body(response);
		}
		
		List<RecompensaDto> listDto = new ArrayList<>();
		list.forEach(recompensa -> listDto.add(this.convertEntityToDto(recompensa)));
		response.setData(listDto);
		return ResponseEntity.ok(response);
	}
	

	@Override
	public RecompensaDto convertEntityToDto(Recompensa recompensa) {
		return recompensaMapper.toDto(recompensa);
	}

	@Override
	public Recompensa convertDtoToEntity(RecompensaDto dto) {
		return recompensaMapper.toEntity(dto);
	}

	@Override
	public RecompensaService getService() {
		return recompensaService;
	}
	
	

}