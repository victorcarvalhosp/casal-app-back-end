package br.com.casalapp.api.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.casalapp.api.dtos.TarefaDto;
import br.com.casalapp.api.entities.Tarefa;
import br.com.casalapp.api.enums.PeriodoTarefaEnum;
import br.com.casalapp.api.mappers.TarefaMapper;
import br.com.casalapp.api.response.Response;
import br.com.casalapp.api.services.PessoaService;
import br.com.casalapp.api.services.TarefaService;


@RestController
@RequestMapping("/tarefas")
@CrossOrigin(origins = "*")
public class TarefaController extends CrudController<Tarefa, TarefaDto>{

	@Autowired
	private TarefaService service;
	
	@Autowired
	private TarefaMapper mapper;
	

	public TarefaController() {
	}
	
	
	@PutMapping(value="{id}/finalizar")
	public ResponseEntity<Response<TarefaDto>> finalizar(@PathVariable("id") Long idTarefa, @Valid @RequestBody TarefaDto dto, BindingResult result) throws NoSuchAlgorithmException {
		log.info("Atualizando registro: {}", dto.toString());
		Response<TarefaDto> response = new Response<TarefaDto>();

		Tarefa entidade = service.atualizarComoFinalizado(idTarefa);  
		
		response.setData(this.convertEntityToDto(entidade));
		return ResponseEntity.ok(response);
	}
	
	@PutMapping(value="{id}/confirmar-finalizacao")
	public ResponseEntity<Response<TarefaDto>> confirmarFinalizacao(@PathVariable("id") Long idTarefa, @Valid @RequestBody TarefaDto dto, BindingResult result) throws NoSuchAlgorithmException {
		log.info("Atualizando registro: {}", dto.toString());
		Response<TarefaDto> response = new Response<TarefaDto>();

		Tarefa entidade = service.atualizarComoFinalizacaoConfirmada(idTarefa);  
		
		response.setData(this.convertEntityToDto(entidade));
		return ResponseEntity.ok(response);
	}


	@PutMapping(value="{id}/cancelar-finalizacao")
	public ResponseEntity<Response<TarefaDto>> cancelarFinalizacao(@PathVariable("id") Long idTarefa, @Valid @RequestBody TarefaDto dto, BindingResult result) throws NoSuchAlgorithmException {
		log.info("Atualizando registro: {}", dto.toString());
		Response<TarefaDto> response = new Response<TarefaDto>();

		Tarefa entidade = service.atualizarComoFinalizacaoNaoConfirmada(idTarefa);

		response.setData(this.convertEntityToDto(entidade));
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value="/parceiro")
	public ResponseEntity<Response<TreeMap<PeriodoTarefaEnum,List <TarefaDto>>>> buscarTarefasParceiroNaoFinalizadas() {
		log.info("Buscando todos os registros");
		Response<TreeMap<PeriodoTarefaEnum,List <TarefaDto>>> response = new Response<TreeMap<PeriodoTarefaEnum,List <TarefaDto>>>();
		Long id = jwtUserDetailsService.getIdPessoaFromHeader();
		
		TreeMap<PeriodoTarefaEnum,List <TarefaDto>> hashMap = getService().buscarTarefasParceiroOrdenadoPorPeriodo(id);
		
		response.setData(hashMap);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value="/pessoa")
	public ResponseEntity<Response<TreeMap<PeriodoTarefaEnum,List <TarefaDto>>>> buscarTarefasPessoaoNaoFinalizadas() {
		Response<TreeMap<PeriodoTarefaEnum,List <TarefaDto>>> response = new Response<TreeMap<PeriodoTarefaEnum,List <TarefaDto>>>();
		Long id = jwtUserDetailsService.getIdPessoaFromHeader();

		TreeMap<PeriodoTarefaEnum,List <TarefaDto>> hashMap = getService().buscarTarefasPessoaOrdenadoPorPeriodo(id);
		
		response.setData(hashMap);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value="/aguardando-confirmacao")
	public ResponseEntity<Response<Iterable <TarefaDto>>> buscarAguardandoConfirmacao() {
		Long id = jwtUserDetailsService.getIdPessoaFromHeader();

		Response<Iterable<TarefaDto>> response = new Response<Iterable<TarefaDto>>();
		Iterable<Tarefa> list = getService().buscarTarefasAguardandoConfirmacao(id);
		if (list == null) {
			log.info("Nenhum registro encontrado");
			response.getErrors().add("Nenhum registro encontrado");
			return ResponseEntity.badRequest().body(response);
		}
		
		List<TarefaDto> listDto = new ArrayList<>();
		list.forEach(lancamento -> listDto.add(this.convertEntityToDto(lancamento)));
		response.setData(listDto);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value="/{pessoaId}")
	public ResponseEntity<Response<Iterable<TarefaDto>>> buscarTarefasPessoa(@PathVariable("pessoaId") Long pessoaId) {
		log.info("Buscando todos os registros");
		Response<Iterable<TarefaDto>> response = new Response<Iterable<TarefaDto>>();
		Iterable<Tarefa> list = getService().buscarTarefasPessoaNaoFinalizadas(pessoaId);
		if (list == null) {
			log.info("Nenhum registro encontrado");
			response.getErrors().add("Nenhum registro encontrado");
			return ResponseEntity.badRequest().body(response);
		}
		
		List<TarefaDto> listDto = new ArrayList<>();
		list.forEach(lancamento -> listDto.add(this.convertEntityToDto(lancamento)));
		response.setData(listDto);
		return ResponseEntity.ok(response);
	}

	@Override
	public TarefaDto convertEntityToDto(Tarefa entidade) {
		return mapper.toDto(entidade);
	}

	@Override
	public Tarefa convertDtoToEntity(TarefaDto dto) {
		return mapper.toEntity(dto);
	}

	@Override
	public TarefaService getService() {
		return service;
	}
	
	

}