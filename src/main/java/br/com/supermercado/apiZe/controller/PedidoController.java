package br.com.supermercado.apiZe.controller;


import br.com.supermercado.apiZe.modelo.Pedido;
import br.com.supermercado.apiZe.repository.PedidoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Samuel
@RestController
@RequestMapping(value = "/api")
public class PedidoController {
    
    @Autowired 
    PedidoRepository pedidoRepository;
    
    @GetMapping("/pedido/read")
    public List<Pedido> Read(){
        return pedidoRepository.findAll(); 
    } 
    
    @GetMapping("/pedido/{id}") 
    public Pedido Busca(@PathVariable(value = "id")long id){
        return pedidoRepository.findById(id); 
    }
    
    @PostMapping("/pedido/create")
    public Pedido Create(@RequestBody Pedido p){
        return pedidoRepository.save(p); 
    }
    
    @DeleteMapping("/pedido/delete/{id}")
    public void  Delete(@PathVariable(value = "id")long id){
        pedidoRepository.deleteById(id);   
    }
    
    @PutMapping("/pedido/update")
    public Pedido Update(@RequestBody Pedido body){
      Pedido p = pedidoRepository.findById(body.getId()).get();
        p.setDataEntrega(body.getDataEntrega());
        p.setLocalEntrega(body.getLocalEntrega());
        p.setDataPedido(body.getDataPedido()); 
        p.setStatusPedido(body.getStatusPedido()); 

        return pedidoRepository.save(p); 
    }
        
}