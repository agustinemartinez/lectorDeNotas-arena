package server.controller;

import model.Usuario;
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
		boolean estaLogueado = token == null ? false : securityService.isLogged( token.replace("Bearer ", "") );
		boolean loginPathRequest = req.pathInfo().equals("/login");
		if( !estaLogueado && !loginPathRequest )
			res.redirect("/login", 303);			
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
			Usuario usuario = securityService.buscarUsuarioPorParametros(req.body());
			String token 	= securityService.token( usuario.getUser() );
			res.cookie("Authorization", token);
		} catch (InvalidTokenException e) {
			Spark.halt(401);
		}
		return null;
	}

	public static ModelAndView logout(Request req, Response res) {
		res.removeCookie("Authorization");
		return null;
	}

}
