package br.com.supermercado.apiZe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.supermercado.apiZe.modelo.Fornecedor;

//Samuel
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{
    
    Fornecedor findById(long id); 
    
}
