package com.spring.wsempleados;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.wsempleados.respuesta.UsuarioToken;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@CrossOrigin("*")
@RestController
@RequestMapping("login")
public class AutenticacionController {

	@PostMapping("usuario")
	private UsuarioToken autenticar(@RequestParam("usuario") String nombreUsuario, @RequestParam("clave") String clave) {
		
		String token = getJWTToken(nombreUsuario);
		UsuarioToken usuarioToken= new UsuarioToken();
		
		
		usuarioToken.setNombreUsuario(nombreUsuario);
		usuarioToken.setToken(token);
		
		
		return usuarioToken;
		
	}
	
	
	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
		.builder()
		.setId("softtekJWT")
		.setSubject(username)
		.claim("authorities",
				grantedAuthorities.stream()
						.map(GrantedAuthority::getAuthority)
						.collect(Collectors.toList()))
		.setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis() + 600000))
		.signWith(SignatureAlgorithm.HS512,
				secretKey.getBytes()).compact();
				

		return "Bearer " + token;
	}
}
