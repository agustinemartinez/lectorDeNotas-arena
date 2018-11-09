package server.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Alumno;
import model.repositories.Repositorios;
import server.security.SecurityService;
import server.utils.TareaViewModel;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class HomeController {
	
	public static ModelAndView home(Request req, Response res){
		String token = req.cookie("Authorization").replace("Bearer ", "");
		String legajo = new SecurityService("god").user(token);

		Alumno alumno = Repositorios.alumnos.getAlumno(legajo);
		List<TareaViewModel> tareas = new ArrayList<TareaViewModel>();
		alumno.getAssignments().forEach( tarea -> tareas.add(TareaViewModel.convert(tarea)) );

		HashMap<String, Object> viewModel = new HashMap<String,Object>();
		viewModel.put("user", alumno.getFirst_name() + " " + alumno.getLast_name());
		viewModel.put("tareas", tareas);
		
		return new ModelAndView (viewModel, "home/home.hbs");
	}
	
}
