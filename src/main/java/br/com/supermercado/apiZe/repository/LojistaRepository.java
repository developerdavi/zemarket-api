package br.com.supermercado.apiZe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.supermercado.apiZe.modelo.Lojista;

public interface LojistaRepository extends JpaRepository<Lojista, Long> {

	List<Lojista> findByNome(String nomeLojista);

	Optional<Lojista> findByEmail(String email);
}
