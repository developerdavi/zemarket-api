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
import br.com.supermercado.apiZe.modelo.Fornecedor;
import br.com.supermercado.apiZe.repository.FornecedorRepository;


//Samuel
@RestController
@RequestMapping(value = "/api")
public class FornecedorController{
    
    
    @Autowired 
    FornecedorRepository fornecedorController;
    
    @GetMapping("/fornecedor/read") 
    public List<Fornecedor> Read(){
        return fornecedorController.findAll(); 
    } 
    
    @GetMapping("/fornecedor/{id}") 
    public Fornecedor Busca(@PathVariable(value = "id")long id){
        return fornecedorController.findById(id); 
    }
    
    @PostMapping("/fornecedor/create")
    public Fornecedor Create(@RequestBody Fornecedor f){
        return fornecedorController.save(f); 
    }
    
    @DeleteMapping("/fornecedor/delete/{id}")
    public void  Delete(@PathVariable(value = "id")long id){
        fornecedorController.deleteById(id);   
    }
    
    @PutMapping("/fornecedor/update")
    public Fornecedor Update(@RequestBody Fornecedor body){
      Fornecedor f = fornecedorController.findById(body.getId()).get();
        f.setNome(body.getNome());
        f.setRua(body.getRua());
        f.setNumero(body.getNumero()); 
        f.setCep(body.getCep()); 
        f.setBairro(body.getBairro()); 
        f.setCnpj(body.getCnpj()); 
        f.setTelefone(body.getTelefone()); 

        return fornecedorController.save(f); 
    }
    
}
