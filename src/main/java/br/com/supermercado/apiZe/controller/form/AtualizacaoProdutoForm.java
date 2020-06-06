package br.com.supermercado.apiZe.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.supermercado.apiZe.modelo.Produto;
import br.com.supermercado.apiZe.repository.ProdutoRepository;

public class AtualizacaoProdutoForm {

	@NotNull @NotEmpty
	private String nome;
	@Length(min = 5)
	private String descricao;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Produto atualizar(Long id, ProdutoRepository produtoRepository) {
		Produto produto = produtoRepository.getOne(id);
		produto.setNome(this.nome);
		produto.setDescricao(this.descricao);
		return produto;
	}
	
	
}
