package br.com.supermercado.apiZe.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.supermercado.apiZe.modelo.Produto;

public class ProdutoDto {

	private Long id;
	private String nome;
	private int estoque;
	private String descricao;
	private double precoVenda;
	
	public ProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.estoque = produto.getEstoque();
		this.descricao = produto.getDescricao();
		this.precoVenda = produto.getPreco_venda();
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

	public static List<ProdutoDto> converter(List<Produto> produtos) {
		return produtos.stream().map(ProdutoDto::new).collect(Collectors.toList());
	}
	
	
}
