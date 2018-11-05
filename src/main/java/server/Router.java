package server;

import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Router {

	public static void configure() {
		HandlebarsTemplateEngine transformer = new HandlebarsTemplateEngine();
		
		Spark.get("/", LoginController::login,transformer);
		Spark.get("/home", HomeController::home,transformer);
	}

}
