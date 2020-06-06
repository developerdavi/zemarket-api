package br.com.supermercado.apiZe.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.supermercado.apiZe.modelo.Cliente;
import br.com.supermercado.apiZe.modelo.Lojista;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${supermercado.jwt.expiration}")
	private String expiration;

	@Value("${supermercado.jwt.secret}")
	private String secret;
	
	public String gerarToken(Authentication authentication) {
		
//		Cliente clienteLogado = (Cliente) authentication.getPrincipal();
		Lojista logado = (Lojista) authentication.getPrincipal();
		Date hoje = new Date();
		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
		
		return Jwts.builder()
				.setIssuer("API do ZeMarket")
				.setSubject(logado.getId().toString())
				//.setSubject(clienteLogado.getId().toString())
				.setIssuedAt(hoje)
				.setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

	public boolean isTokenValido(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);			
			return true;
		} catch (Exception e) {			
			return false;
		}
		
	}

	public Long getIdUsuario(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
	}

}
