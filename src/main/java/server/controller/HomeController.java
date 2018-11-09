package server.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import model.Alumno;
import model.Nota;
import model.Tarea;
import model.Usuario;
import model.repositories.Repositorios;
import request.RequestService;
import server.security.SecurityService;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class HomeController {
	
	public static ModelAndView home(Request req, Response res){
		String token = req.cookie("Authorization").replace("Bearer ", "");
		String legajo = new SecurityService("god").user(token);
		System.out.println(legajo);
		Alumno alumno = Repositorios.alumnos.getAlumno("1");//legajo);

		System.out.println(alumno.getFirst_name() + " " + alumno.getLast_name());
		HashMap<String, Object> viewModel = new HashMap<String,Object>();
//		viewModel.put("user", alumno.getFirst_name() + " " + alumno.getLast_name());
//
//		List<Tarea> tareas = alumno.getAssignments();
//		viewModel.put("tareas", tareas);
		
		return new ModelAndView (viewModel, "home/home.hbs");
	}
	
}
