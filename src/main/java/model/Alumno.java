package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.repositories.RepoAlumnos;

import org.uqbar.commons.model.annotations.Observable;

@Observable
public class Alumno {
	
	private String legajo;
	private String nombre;
	private String apellido;
	private String usuario;
	private List<Tarea> tareas;
	
	public Alumno(String legajo, String nombre, String apellido, String usuario) {
		this.nombre   = nombre;
		this.apellido = apellido;
		this.legajo   = legajo;
		this.usuario  = usuario;
		this.tareas   = new ArrayList<Tarea>();;
	}
	
	public String getLegajo() { return legajo; }
	public String getNombre() { return nombre; }
	public String getApellido() { return apellido; }
	public String getUsuario() { return usuario; }
	public List<Tarea> getTareas() { return tareas; }

	public void setNombre(String nombre) { this.nombre = nombre; }
	public void setApellido(String apellido) { this.apellido = apellido; }
	public void setLegajo(String legajo) { this.legajo = legajo; }
	public void setUsuario(String usuario) { this.usuario = usuario; }
	public void setTareas(List<Tarea> tareas) { this.tareas = tareas; }

	public void agregarTarea(Tarea tarea) { this.tareas.add(tarea); }
	
//	public List<String> getNombreTareas() { return this.tareas.stream().map(t -> t.getDescripcion()).collect(Collectors.toList()); }
	
//	public void cargarDatos() {
//		try {
//			Alumno a = RepoAlumnos.getInstance().getAlumno(this.legajo);
//			this.nombre   = a.getNombre();
//			this.apellido = a.getApellido();
//			this.legajo   = a.getLegajo();
//			this.usuario  = a.getUsuario();
//			this.tareas   = a.getTareas();
//			this.tareaSeleccionada = this.tareas.get(0);
//			this.nota = this.tareaSeleccionada.getNotaActual();
//			this.aprobada = this.tareaSeleccionada.getAprobada()?Estado.Aprobado:Estado.Desaprobado;
//		}
//		catch(IndexOutOfBoundsException e) { 
//			this.nombre   = "";
//			this.apellido = "";
//			this.usuario  = "";
//			this.tareas   = null;
//			this.tareaSeleccionada = null; 
//			this.nota = "-";
//			this.aprobada = null;
//		}
//	}	

}
