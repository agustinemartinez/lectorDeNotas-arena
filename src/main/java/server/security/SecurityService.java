package server.security;

import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import model.Usuario;
import model.repositories.Repositorios;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class SecurityService {

	private String secret;

	public SecurityService(String secret) {
		this.secret = secret;
	}
	
	public String token(String username) {
	    Algorithm algorithm = Algorithm.HMAC256(secret);
	    JWTCreator.Builder builder = com.auth0.jwt.JWT.create();
	    builder.withClaim("user", username);
	    return builder.sign(algorithm);
	}

	public String user(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			JWTVerifier verifier = JWT.require(algorithm).build();
			DecodedJWT jwt = verifier.verify(token);
			return jwt.getClaim("user").asString();
		} catch (JWTVerificationException e) {
			throw new InvalidTokenException(e);
		}
	}

	public boolean isLogged(String token) {
		String user = user(token);
		return Repositorios.usuarios.getUsuario(user) != null;
	}
	
	public Usuario buscarUsuarioPorParametros(String params) {
		try {			
			Map<String,String> map = Pattern.compile("\\s*&\\s*")
	                .splitAsStream(params.trim())
	                .map(s -> s.split("=", 2))
	                .collect(Collectors.toMap(a -> a[0], a -> a.length > 1 ? a[1]: ""));
			String nombreUsuario = map.get("user").toString();
			String contrasena 	 = map.get("pass").toString();
			Usuario usuario = Repositorios.usuarios.getUsuario(nombreUsuario);
			if(!usuario.correctPassword(contrasena))
				throw new InvalidTokenException();
			return usuario;
		} catch(Exception ex) {			
			throw new InvalidTokenException();
		}		
	}

}
