package br.com.supermercado.apiZe.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.supermercado.apiZe.modelo.Cliente;
import br.com.supermercado.apiZe.modelo.Lojista;
import br.com.supermercado.apiZe.repository.ClienteRepository;
import br.com.supermercado.apiZe.repository.LojistaRepository;

@Service
public class AutenticacaoService implements UserDetailsService{

	@Autowired
	private LojistaRepository repository;

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Lojista> lojista = repository.findByEmail(username);
		
		Optional<Cliente> cliente = clienteRepository.findByEmail(username);
		

		if(lojista.isPresent()) {
			return lojista.get();
		}else if(cliente.isPresent()) {
			return cliente.get();
		}
		throw new UsernameNotFoundException("Dados Inválidos!");
	}

}
