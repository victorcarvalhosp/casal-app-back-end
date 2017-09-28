package br.com.casalapp.api.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

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

import br.com.casalapp.api.dtos.ListaTarefasDto;
import br.com.casalapp.api.entities.ListaTarefas;
import br.com.casalapp.api.mappers.ListaTarefasMapper;
import br.com.casalapp.api.response.Response;
import br.com.casalapp.api.services.ListaTarefasService;


@RestController
@RequestMapping("/listaTarefas")
@CrossOrigin(origins = "*")
public class ListaTarefasController extends CrudController<ListaTarefas, ListaTarefasDto>{

	@Autowired
	private ListaTarefasService listaTarefasService;
	
	@Autowired
	private ListaTarefasMapper listaTarefasMapper;
	

	public ListaTarefasController() {
	}
	
	@PostMapping
	@Override
	public ResponseEntity<Response<ListaTarefasDto>> cadastrar(@Valid @RequestBody ListaTarefasDto dto,
			BindingResult result) throws NoSuchAlgorithmException {
		Response<ListaTarefasDto> response = new Response<ListaTarefasDto>();

		log.info("Inserindo registro: {}", dto.toString());

		ListaTarefas entidade = this.convertDtoToEntity(dto);
		
		getService().save(entidade);
		response.setData(this.convertEntityToDto(entidade));
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value="/modelos")
	public ResponseEntity<Response<Iterable<ListaTarefasDto>>> buscarModelos() {
		log.info("Buscando todos os registros");
		Response<Iterable<ListaTarefasDto>> response = new Response<Iterable<ListaTarefasDto>>();
		Iterable<ListaTarefas> list = getService().buscarModelos();
		if (list == null) {
			log.info("Nenhum registro encontrado");
			response.getErrors().add("Nenhum registro encontrado");
			return ResponseEntity.badRequest().body(response);
		}
		
		List<ListaTarefas> clones = clonarSugestoes(list);
		List<ListaTarefasDto> listDto = new ArrayList<>();
		clones.forEach(listaTarefas -> listDto.add(this.convertEntityToDto(listaTarefas)));
		response.setData(listDto);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value="/verificarCadastrouAlgo")
	public ResponseEntity<Response<Boolean>> verificarCadastrouAlgo() {
		log.info("Verificando se já cadastrou algo");
		Response<Boolean> response = new Response<Boolean>();
		Long id = jwtUserDetailsService.getIdPessoaFromHeader();
		Boolean totalCadastro = getService().verificarSeJahRealizouAlgumCadastro(id);

		if (totalCadastro == null) {
			log.info("Nenhum registro encontrado");
			response.getErrors().add("Nenhum registro encontrado");
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(totalCadastro);
		return ResponseEntity.ok(response);
	}

	private List<ListaTarefas> clonarSugestoes(Iterable<ListaTarefas> list) {
		List<ListaTarefas> clones = new ArrayList<>();
		for (ListaTarefas listaTarefas : list) {
			try {
				ListaTarefas clone = (ListaTarefas) listaTarefas.clone();
				clones.add(clone);
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return clones;
	}
	
	@Override
	public ListaTarefasDto convertEntityToDto(ListaTarefas listaTarefas) {
		return listaTarefasMapper.toDto(listaTarefas);
	}

	@Override
	public ListaTarefas convertDtoToEntity(ListaTarefasDto dto) {
		return listaTarefasMapper.toEntity(dto);
	}

	@Override
	public ListaTarefasService getService() {
		return listaTarefasService;
	}
	
	

}