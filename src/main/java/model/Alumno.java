package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.repositories.RepoAlumnos;

import org.uqbar.commons.model.annotations.Observable;

@Observable
public class Alumno {
	
	String nombre;
	String apellido;
	long legajo;
	String usuario;
	List<Tarea> tareas;
	Tarea tareaSeleccionada;
	String nota;
	Estado aprobada;
	
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	public String getApellido() { return apellido; }
	public void setApellido(String apellido) { this.apellido = apellido; }
	public long getLegajo() { return legajo; }
	public void setLegajo(long legajo) { this.legajo = legajo; }
	public String getUsuario() { return usuario; }
	public void setUsuario(String usuario) { this.usuario = usuario; }
	public List<Tarea> getTareas() { return tareas; }
	public List<String> getNombreTareas() { return tareas.stream().map(t -> t.getNombre()).collect(Collectors.toList()); }
	public void setTareas(List<Tarea> tareas) { this.tareas = tareas; }
	public Tarea getTareaSeleccionada() { return tareaSeleccionada; }
	public void setTareaSeleccionada(Tarea tareaSeleccionada) { this.tareaSeleccionada = tareaSeleccionada; }

	public String getNota() { return nota; }
	public void setNota(String nota) { this.nota = nota; }
	public Estado getAprobada() { return aprobada; }
	public void setAprobada(Estado aprobada) { this.aprobada = aprobada; }

	public void agregarTarea(Tarea tarea) { 
		if (this.tareas == null)
			this.tareas = new ArrayList<>();
		this.tareas.add(tarea); 
	}
	
	public void cargarDatos() {
		try {
			Alumno a = RepoAlumnos.getInstance().getAlumno(this.legajo);
			this.nombre   = a.getNombre();
			this.apellido = a.getApellido();
			this.legajo   = a.getLegajo();
			this.usuario  = a.getUsuario();
			this.tareas   = a.getTareas();
			this.tareaSeleccionada = this.tareas.get(0);
			this.nota = this.tareaSeleccionada.getNotaActual();
			this.aprobada = this.tareaSeleccionada.getAprobada()?Estado.Aprobado:Estado.Desaprobado;
		}
		catch(IndexOutOfBoundsException e) { 
			this.nombre   = "";
			this.apellido = "";
			this.usuario  = "";
			this.tareas   = null;
			this.tareaSeleccionada = null; 
			this.nota = "-";
			this.aprobada = null;
		}
	}
	
	public void guardarCambios() {
		RepoAlumnos.getInstance().setAlumno(this);
	}	
}
