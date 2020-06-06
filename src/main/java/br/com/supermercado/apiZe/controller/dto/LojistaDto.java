package br.com.supermercado.apiZe.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.supermercado.apiZe.modelo.Lojista;

public class LojistaDto {

	private Long id;
	private String nome;
	private String telefone;
	private String cargo;
	
	public LojistaDto(Lojista lojista) {
		this.id = lojista.getId();
		this.nome = lojista.getNome();
		this.telefone = lojista.getTelefone();
		this.cargo = lojista.getCargo();
	}
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public String getCargo() {
		return cargo;
	}

	public static List<LojistaDto> converter(List<Lojista> lojistas) {
		return lojistas.stream().map(LojistaDto::new).collect(Collectors.toList());
	}
	
	
}
