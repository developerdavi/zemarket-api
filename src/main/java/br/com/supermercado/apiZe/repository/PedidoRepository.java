package br.com.supermercado.apiZe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.supermercado.apiZe.modelo.Pedido;

//Samuel
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
    Pedido findById(long id); 
    
}
