package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class RepoAlumnos {
	
	static RepoAlumnos instancia;
	List<Alumno> alumnos;
	
	private RepoAlumnos() {
		this.alumnos = new ArrayList<Alumno>();
		
		Alumno juanPerez = new Alumno();
		juanPerez.setNombre("Juan");
		juanPerez.setApellido("Perez");
		juanPerez.setLegajo(123456);
		juanPerez.setUsuario("juanPerez");		
		Tarea parcial1 = new Tarea("Parcial 1", Arrays.asList("2", "6"));
		juanPerez.agregarTarea(parcial1);
		
		this.alumnos.add(juanPerez);
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
