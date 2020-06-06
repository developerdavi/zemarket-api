package br.com.supermercado.apiZe.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.supermercado.apiZe.modelo.Lojista;
import br.com.supermercado.apiZe.repository.LojistaRepository;

public class AtualizacaoLojistaForm {

	@NotNull @NotEmpty
	private String nome;
	@Length(min = 8)
	private String telefone;
	@NotNull @NotEmpty
	private String cargo;
	@NotNull @NotEmpty
	private String senha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Lojista atualizar(Long id, LojistaRepository lojistaRepository) {
		Lojista lojista = lojistaRepository.getOne(id);
		lojista.setNome(this.nome);
		lojista.setTelefone(this.telefone);
		lojista.setCargo(this.cargo);
		lojista.setSenha(this.senha);
		
		return lojista;
	}
	
	
}
