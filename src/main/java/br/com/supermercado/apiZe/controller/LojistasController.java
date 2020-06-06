package br.com.supermercado.apiZe.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.supermercado.apiZe.controller.dto.DetalhesDoLojistaDto;
import br.com.supermercado.apiZe.controller.dto.LojistaDto;
import br.com.supermercado.apiZe.controller.form.AtualizacaoLojistaForm;
import br.com.supermercado.apiZe.controller.form.LojistaForm;
import br.com.supermercado.apiZe.modelo.Lojista;
import br.com.supermercado.apiZe.repository.LojistaRepository;

@RestController
@RequestMapping("/lojistas")
public class LojistasController {

	@Autowired
	private LojistaRepository LojistaRepository;
	
	@GetMapping
	public List<LojistaDto> lista(String nomeLojista) {
		if(nomeLojista == null) {
			List<Lojista> lojistas = LojistaRepository.findAll();
			return LojistaDto.converter(lojistas);
		}else {
			List<Lojista> lojistas = LojistaRepository.findByNome(nomeLojista);
			return LojistaDto.converter(lojistas);
		}	
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<LojistaDto> cadastrar(@RequestBody @Valid LojistaForm form, UriComponentsBuilder uriBuilder) {
		Lojista lojista = form.converter();
		LojistaRepository.save(lojista);
		
		URI uri = uriBuilder.path("/lojistas/{id}").buildAndExpand(lojista.getId()).toUri();
		return ResponseEntity.created(uri).body(new LojistaDto(lojista));
	}
	
	@GetMapping("/{id}")
	public DetalhesDoLojistaDto detalhar(@PathVariable Long id) {
	
		Lojista lojista = LojistaRepository.getOne(id);
	
		return new DetalhesDoLojistaDto(lojista);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<LojistaDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoLojistaForm form){
		Lojista lojista = form.atualizar(id, LojistaRepository);
		
		
		return ResponseEntity.ok(new LojistaDto(lojista));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<LojistaDto> remover(@PathVariable Long id){
		 LojistaRepository.deleteById(id);
		 return ResponseEntity.ok().build();
	}
}
