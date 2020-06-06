package br.com.supermercado.apiZe.controller;

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

import br.com.supermercado.apiZe.modelo.Cliente;
import br.com.supermercado.apiZe.repository.ClienteRepository;

//Samuel
public class ClienteController {
	@RestController
	@RequestMapping(value = "/api")
	public class clienteResource {
	    
	    @Autowired 
	    ClienteRepository clienteRepository;
	    
	    @GetMapping("/cliente/read") 
	    public List<Cliente> Read(){
	        return clienteRepository.findAll(); 
	    } 
	    
	    @GetMapping("/cliente/{id}") 
	    public Cliente Busca(@PathVariable(value = "id")long id){
	        return clienteRepository.findById(id); 
	    }
	    
	    @PostMapping("/cliente/create")
	    public Cliente Create(@RequestBody Cliente c){
	        return clienteRepository.save(c); 
	    }
	    
	    @DeleteMapping("/cliente/delete/{id}")
	    public void  Delete(@PathVariable(value = "id")long id){
	        clienteRepository.deleteById(id);   
	    }
	    
	    @PutMapping("/cliente/update/personal")
	    public Cliente UpdatePersonal(@RequestBody Cliente body){
	      Cliente c = clienteRepository.findById(body.getId()).get();
	        c.setNome(body.getNome());
	        c.setCpf(body.getCpf());
	        c.setNascimento(body.getNascimento()); 
	        c.setTelefone(body.getTelefone()); 

	        return clienteRepository.save(c); 
	    }
	    
	    @PutMapping("/cliente/update/adress")
	    public Cliente UpdateAdress(@RequestBody Cliente body){
	      Cliente c = clienteRepository.findById(body.getId()).get();
	        c.setRua(body.getRua());
	        c.setBairro(body.getBairro());
	        c.setNumero(body.getNumero()); 
	        c.setComplemento(body.getComplemento()); 

	        return clienteRepository.save(c); 
	    }
	    
	     @PutMapping("/cliente/update/password")
	     public Cliente UpdatePassword(@RequestBody Cliente body){
	      Cliente c = clienteRepository.findById(body.getId()).get();
	        c.setSenha(body.getSenha());
	         
	        return clienteRepository.save(c); 
	    }
}
}