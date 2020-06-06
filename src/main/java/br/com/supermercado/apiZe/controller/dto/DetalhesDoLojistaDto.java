package br.com.supermercado.apiZe.controller.dto;

import br.com.supermercado.apiZe.modelo.Lojista;

public class DetalhesDoLojistaDto {

	private String nome;
	private String cpf;
	private String telefone;
	private String cargo;
	
	public DetalhesDoLojistaDto(Lojista lojista) {
		this.nome = lojista.getNome();
		this.cpf = lojista.getCpf();
		this.telefone = lojista.getTelefone();
		this.cargo = lojista.getCargo();
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCargo() {
		return cargo;
	}
	
}
