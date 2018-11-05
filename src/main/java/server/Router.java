package server;

import server.controller.HomeController;
import server.controller.LoginController;
import server.utils.HandlebarsTemplateEngineBuilder;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Router {
	public static void configure() {
		HandlebarsTemplateEngine engine = HandlebarsTemplateEngineBuilder
				.create()
				.withDefaultHelpers()
				.build();
		
		Spark.staticFiles.location("/public");
		Spark.before(LoginController::authentication); 

		Spark.get("/"		, HomeController::home	 , engine);
		Spark.get("/login"  , LoginController::show  , engine);
		
		Spark.post("/login" , LoginController::login , engine);
		Spark.post("/logout", LoginController::logout, engine);
	}
}
