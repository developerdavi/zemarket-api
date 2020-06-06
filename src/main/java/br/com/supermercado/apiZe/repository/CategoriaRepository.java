package br.com.supermercado.apiZe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.supermercado.apiZe.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	Categoria findByNome(String nome);

}
