package br.com.supermercado.apiZe.controller.form;

import java.util.Calendar;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.supermercado.apiZe.modelo.Categoria;
import br.com.supermercado.apiZe.modelo.Produto;
import br.com.supermercado.apiZe.repository.CategoriaRepository;

public class ProdutoForm {

	@NotNull @NotEmpty
	private String nome;
	@Length(min = 5)
	private String descricao;
	private int estoque;
	private Calendar data_validade;
	private double preco_venda;
	private double preco_custo;
	private String nomeCategoria;
	
	
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


	public int getEstoque() {
		return estoque;
	}


	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}


	public Calendar getData_validade() {
		return data_validade;
	}


	public void setData_validade(Calendar data_validade) {
		this.data_validade = data_validade;
	}


	public double getPreco_venda() {
		return preco_venda;
	}


	public void setPreco_venda(double preco_venda) {
		this.preco_venda = preco_venda;
	}


	public double getPreco_custo() {
		return preco_custo;
	}


	public void setPreco_custo(double preco_custo) {
		this.preco_custo = preco_custo;
	}


	public String getNomeCategoria() {
		return nomeCategoria;
	}


	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}


	public Produto converter(CategoriaRepository categoriaRepository) {
		Categoria categoria = categoriaRepository.findByNome(nomeCategoria);
		return new Produto(nome, estoque, data_validade, categoria, descricao,
				preco_venda, preco_custo);
	}
	
}
