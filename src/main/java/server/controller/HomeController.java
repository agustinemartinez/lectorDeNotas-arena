package server.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import model.Nota;
import model.Tarea;
import model.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class HomeController {
	
	public static ModelAndView home(Request req, Response res){
		HashMap<String,Object> viewModel = new HashMap<String,Object>();
		viewModel.put("user",Usuario.getUser());
		
		//List<Tarea> tareas = Usuario.getTareas();
		List<Tarea> tareas = Arrays.asList(new Tarea("iys"));
		viewModel.put("tareas",tareas);
		
									
		return new ModelAndView (viewModel, "home/home.hbs");
	}
	
}
