package ui.vm;

import java.awt.Color;
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
	private String estadoTarea;
	private Color fondoEstadoTarea;

	public AlumnoViewModel() { 
		this.alumnos = Repositorios.alumnos.all(); 
		this.alumnoSeleccionado = new Alumno("", "", "", "");
		this.limpiarEstadoTarea();
	}

	public Alumno getAlumnoSeleccionado() { return this.alumnoSeleccionado; }
	public Tarea getTareaSeleccionada() { return this.tareaSeleccionada; }
	public String getLegajoIngresado() { return this.legajoIngresado; }
	public String getEstadoTarea() { return this.estadoTarea; }
	public Color getFondoEstadoTarea() { return this.fondoEstadoTarea; }
	public void setAlumnoSeleccionado(Alumno alumnoSeleccionado) { this.alumnoSeleccionado = alumnoSeleccionado; }
	public void setLegajoIngresado(String legajoIngresado) { this.legajoIngresado = legajoIngresado; }

	public void setTareaSeleccionada(Tarea tareaSeleccionada) { 
		this.tareaSeleccionada = tareaSeleccionada; 
		if (tareaSeleccionada.getNotaActual().estaAprobada()) {
			this.estadoTarea = "Aprobado";
			this.fondoEstadoTarea = Color.GREEN;
		}
		else {
			this.estadoTarea = "Desaprobado";
			this.fondoEstadoTarea = Color.RED;
		}
	}	
	
	public void cargarAlumno() {
		this.alumnoSeleccionado = this.alumnos.stream()
											  .filter(alu -> alu.getLegajo().equals(legajoIngresado))
											  .collect(Collectors.toList())
											  .get(0);
		this.limpiarEstadoTarea();
	}

	private void limpiarEstadoTarea() {
		this.tareaSeleccionada = new Tarea("").agregarNota("-");
		this.estadoTarea = "-";
		this.fondoEstadoTarea = Color.GRAY;		
	}
	
}
