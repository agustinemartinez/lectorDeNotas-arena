package ui.vm;

import java.util.List;
import java.util.stream.Collectors;

import model.Alumno;
import model.Tarea;
import model.repositories.RepoAlumnos;
import model.repositories.Repositorios;

import org.uqbar.commons.model.annotations.Observable;

@Observable
public class AlumnoViewModel {

	private List<Alumno> alumnos;
	private String legajoIngresado;
	private Alumno alumnoSeleccionado;
	private Tarea tareaSeleccionada;
	
	public AlumnoViewModel() { 
		this.alumnos = Repositorios.alumnos.all(); 
		this.alumnoSeleccionado = new Alumno("", "", "", "");
	}

	public Alumno getAlumnoSeleccionado() { return alumnoSeleccionado; }
	public Tarea getTareaSeleccionada() { return tareaSeleccionada; }
	public String getLegajoIngresado() { return legajoIngresado; }
	public void setAlumnoSeleccionado(Alumno alumnoSeleccionado) { this.alumnoSeleccionado = alumnoSeleccionado; }
	public void setTareaSeleccionada(Tarea tareaSeleccionada) { this.tareaSeleccionada = tareaSeleccionada; }
	public void setLegajoIngresado(String legajoIngresado) { this.legajoIngresado = legajoIngresado; }

	public void cargarAlumno() {
		this.alumnoSeleccionado = this.alumnos.stream()
									   .filter(alu -> alu.getLegajo().equals(legajoIngresado))
									   .collect(Collectors.toList())
									   .get(0);
	}

}
