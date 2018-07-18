package model.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

import model.Alumno;
import model.Tarea;

public class RepoAlumnos {
	
	//private static RepoAlumnos instancia;
	private List<Alumno> alumnos;
	
	public RepoAlumnos() { this.alumnos = new ArrayList<Alumno>(); }
	
	public void agregarAlumno(Alumno alumno) { this.alumnos.add(alumno); }
	public List<Alumno> all() { return this.alumnos; }

//	public static RepoAlumnos getInstance() {
//		if (instancia == null)
//			instancia = new RepoAlumnos();
//		return instancia;
//	}
	
//	public Alumno getAlumno(long legajo) {
//		return this.alumnos.stream()
//				  		   .filter(alu -> alu.getLegajo() == legajo)
//				  		   .collect(Collectors.toList())
//				  		   .get(0);
//	}
//	
//	public void setAlumno(Alumno alu) {
//		int pos = this.alumnos.stream()
//							  .map(a -> a.getLegajo())
//							  .collect(Collectors.toList())
//							  .indexOf(alu.getLegajo());
//		if (pos >= 0)
//			this.alumnos.set(pos, alu);
//	}

}

