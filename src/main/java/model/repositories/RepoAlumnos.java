package model.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

import model.Alumno;
import model.Tarea;

public class RepoAlumnos {
	
	static RepoAlumnos instancia;
	List<Alumno> alumnos;
	
	private RepoAlumnos() {
		this.alumnos = new ArrayList<Alumno>();
		
		Alumno juanPerez = new Alumno();
		juanPerez.setNombre("Juan");
		juanPerez.setApellido("Perez");
		juanPerez.setLegajo(1);
		juanPerez.setUsuario("juanPerez");		
		Tarea parcial1 = new Tarea("Parcial 1", Arrays.asList("2", "6"));
		Tarea parcial2 = new Tarea("Parcial 2", Arrays.asList("3"));
		juanPerez.agregarTarea(parcial1);
		juanPerez.agregarTarea(parcial2);

		Alumno alu = new Alumno();
		alu.setNombre("Alu");
		alu.setApellido("Alu");
		alu.setLegajo(2);
		alu.setUsuario("alualu");		
		Tarea parcial3 = new Tarea("Parcial 1", Arrays.asList("4"));
		alu.agregarTarea(parcial3);
		
		this.alumnos.add(juanPerez);
		this.alumnos.add(alu);
	}
	
	public static RepoAlumnos getInstance() {
		if (instancia == null)
			instancia = new RepoAlumnos();
		return instancia;
	}
	
	public Alumno getAlumno(long legajo) {
		return this.alumnos.stream()
				  		   .filter(alu -> alu.getLegajo() == legajo)
				  		   .collect(Collectors.toList())
				  		   .get(0);
	}
	
	public void setAlumno(Alumno alu) {
		int pos = this.alumnos.stream()
							  .map(a -> a.getLegajo())
							  .collect(Collectors.toList())
							  .indexOf(alu.getLegajo());
		if (pos >= 0)
			this.alumnos.set(pos, alu);
	}
}

