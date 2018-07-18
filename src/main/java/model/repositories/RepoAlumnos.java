package model.repositories;

import java.util.ArrayList;
import java.util.List;

import model.Alumno;

public class RepoAlumnos {
	
	private List<Alumno> alumnos;
	
	public RepoAlumnos() { this.alumnos = new ArrayList<Alumno>(); }
	
	public void agregarAlumno(Alumno alumno) { this.alumnos.add(alumno); }
	public List<Alumno> all() { return this.alumnos; }
	public void setAlumnos(List<Alumno> alumnos) { this.alumnos = alumnos; }

}

