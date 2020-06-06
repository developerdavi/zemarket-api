package br.com.supermercado.apiZe.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Produto {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private int estoque;
	private Calendar validade;
	@OneToOne
	private Categoria categoria;
	private String descricao;
	private double precoVenda;
	private double precoCusto;
	
	public Produto() {
		
	}
	
	public Produto(String nome, int estoque, Calendar data_validade, Categoria categoria, String descricao,
			double preco_venda, double preco_custo) {
		this.nome = nome;
		this.estoque = estoque;
		this.validade = data_validade;
		this.categoria = categoria;
		this.descricao = descricao;
		this.precoVenda = preco_venda;
		this.precoCusto = preco_custo;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public Calendar getData_validade() {
		return validade;
	}
	public void setData_validade(Calendar data_validade) {
		this.validade = data_validade;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPreco_venda() {
		return precoVenda;
	}
	public void setPreco_venda(double preco_venda) {
		this.precoVenda = preco_venda;
	}
	public double getPreco_custo() {
		return precoCusto;
	}
	public void setPreco_custo(double preco_custo) {
		this.precoCusto = preco_custo;
	}
	
	
}
