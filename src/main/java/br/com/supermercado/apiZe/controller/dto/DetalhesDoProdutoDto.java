package br.com.supermercado.apiZe.controller.dto;

import java.util.Calendar;

import br.com.supermercado.apiZe.modelo.Produto;

public class DetalhesDoProdutoDto {

	private Long id;
	private String nome;
	private int estoque;
	private String descricao;
	private double precoVenda;
	private String nomeCategoria;
	private Calendar data_validade;

	public DetalhesDoProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.estoque = produto.getEstoque();
		this.descricao = produto.getDescricao();
		this.precoVenda = produto.getPreco_venda();
		this.nomeCategoria = produto.getCategoria().getNome();
		this.data_validade = produto.getData_validade();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getEstoque() {
		return estoque;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public Calendar getData_validade() {
		return data_validade;
	}
	
}
