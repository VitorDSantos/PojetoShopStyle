package mscostumer.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import mscostumer.model.Usuario;

@Service
public class TokenService {
	
	@Value("${mscostumer.jwt.expiration}")
	private String expiration;
	
	@Value("${mscostumer.jwt.secret}")
	private String secret;
	
	public String gerarToken(Authentication authentication) {
		Usuario logado = (Usuario) authentication.getPrincipal();
		Date data = new Date();
		Date dataFinal = new Date(data.getTime() + Long.parseLong(expiration));
		return Jwts.builder()
				.setIssuer("Usuario")
				.setSubject(logado.getId().toString())
				.setIssuedAt(data)
				.setExpiration(dataFinal)
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
