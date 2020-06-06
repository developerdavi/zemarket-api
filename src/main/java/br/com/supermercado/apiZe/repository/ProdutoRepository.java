package br.com.supermercado.apiZe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.supermercado.apiZe.modelo.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	List<Produto> findByCategoriaNome(String nomeCategoria);

}
