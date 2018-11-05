package server.controller;

import model.Usuario;
import model.repositories.Repositorios;
import server.security.InvalidTokenException;
import server.security.SecurityService;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;

public class LoginController {
	
	private static SecurityService securityService = new SecurityService("god");
	
	public static void authentication(Request req, Response res) {
		String token = req.cookie("Authorization");		
		System.out.println("Cookie: " + token);
		boolean estaLogueado = token == null ? false : securityService.isLogged( token.replace("Bearer ", "") );
		boolean loginPathRequest = req.pathInfo().equals("/login");
		if( !estaLogueado && !loginPathRequest )
			res.redirect("/login");			
	}

	public static ModelAndView show(Request req, Response res) {
		String token = req.cookie("Authorization");		
		boolean estaLogueado = token == null ? false : securityService.isLogged( token.replace("Bearer ", "") );
		if( estaLogueado )
			return HomeController.home(req, res);
		return new ModelAndView(null, "login/login.hbs");
	}
	
	public static ModelAndView login(Request req, Response res) {
		try {
			Usuario usuario = buscarUsuarioPorParametros(req.body());
			securityService.add(usuario);
			String token = securityService.token( usuario.getUser() );
			System.out.println("Token asignado: " + token);
			res.cookie("Authorization", token);
			res.redirect("/home");
		} catch (InvalidTokenException e) {
			//LoginController.show(req, res);
			Spark.halt(401);
		}
		return null;
	}

	public static ModelAndView logout(Request req, Response res) {
		String token = req.cookie("Authorization").replace("Bearer ", "");
		securityService.remove(token);
		res.removeCookie("Authorization");
		res.redirect("/login");
		return null;
	}

	private static Usuario buscarUsuarioPorParametros(String params) {
		//response.type("application/json")
		try {			
			String nombreUsuario = getParametro("user", params);
			String contrasena 	 = getParametro("pass", params);
			Usuario usuario = Repositorios.usuarios.getUsuario(nombreUsuario);
			if(!usuario.correctPassword(contrasena))
				throw new InvalidTokenException();
			return usuario;
		} catch(Exception ex) {			
			throw new InvalidTokenException();
		}		
	}

	private static String getParametro(String parametro, String listaDeParametros) {	
		int p1 = listaDeParametros.indexOf(parametro) + parametro.length() + 1;
		int p2 = listaDeParametros.indexOf('&', p1);
		return listaDeParametros.indexOf(parametro)<0 ? "" : listaDeParametros.substring(p1, p2);
	}

}
