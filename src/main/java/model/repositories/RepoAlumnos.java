package model.repositories;

import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

import request.RequestService;
import model.Alumno;

public class RepoAlumnos {
	
	private List<Alumno> alumnos;
	
	public RepoAlumnos() { this.alumnos = new ArrayList<Alumno>(); }
	
	public void agregarAlumno(Alumno alumno) { this.alumnos.add(alumno); }
	public List<Alumno> all() { return this.alumnos; }
	public void setAlumnos(List<Alumno> alumnos) { this.alumnos = alumnos; }
	
	public Alumno getAlumno(String legajo) {
		return new RequestService().getAlumno(legajo);
//		return alumnos.stream()
//					  .filter(alu -> alu.getCode().equals(legajo))
//					  .collect(Collectors.toList())
//					  .get(0);
	}

	public void guardarAlumno(Alumno alumno) {
		new RequestService().putAlumno(alumno);
	}
	
}

