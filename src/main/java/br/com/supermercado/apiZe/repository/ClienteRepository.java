package br.com.supermercado.apiZe.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.supermercado.apiZe.modelo.Cliente;

//Samuel
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    Cliente findById(long id); 
  
    Optional<Cliente> findByEmail(String Email);
}
