package ui.vm;

import java.util.List;
import java.util.stream.Collectors;

import model.Alumno;
import model.Tarea;
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
		this.tareaSeleccionada = new Tarea("").agregarNota("-");
		this.tareaSeleccionada.getNotaActual().setEstado("-");
	}

	public Alumno getAlumnoSeleccionado() { return this.alumnoSeleccionado; }
	public Tarea getTareaSeleccionada() { return this.tareaSeleccionada; }
	public String getLegajoIngresado() { return this.legajoIngresado; }
	public void setAlumnoSeleccionado(Alumno alumnoSeleccionado) { this.alumnoSeleccionado = alumnoSeleccionado; }
	public void setTareaSeleccionada(Tarea tareaSeleccionada) { this.tareaSeleccionada = tareaSeleccionada; }
	public void setLegajoIngresado(String legajoIngresado) { this.legajoIngresado = legajoIngresado; }

	public void cargarAlumno() {
		this.alumnoSeleccionado = this.alumnos.stream()
											  .filter(alu -> alu.getLegajo().equals(legajoIngresado))
											  .collect(Collectors.toList())
											  .get(0);
	}

	public void guardarAlumno() {
		int pos = this.alumnos.stream()
							  .map(a -> a.getLegajo())
							  .collect(Collectors.toList())
							  .indexOf(this.alumnoSeleccionado.getLegajo());
		if (pos >= 0) {
			this.alumnos.remove(pos);
			this.alumnos.add(this.alumnoSeleccionado);
		}
		Repositorios.alumnos.setAlumnos(this.alumnos);
	}

}
