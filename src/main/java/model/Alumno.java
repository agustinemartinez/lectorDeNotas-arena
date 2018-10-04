package model;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.annotations.Observable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Observable
@JsonIgnoreProperties(value = { "changeSupport" })
public class Alumno {
	
	private String code;
	private String first_name;
	private String last_name;
	private String github_user;
	private List<Tarea> assignments;
	
	public Alumno() { }
	
	public Alumno(String legajo, String nombre, String apellido, String usuario) {
		this.first_name   = nombre;
		this.last_name = apellido;
		this.code   = legajo;
		this.github_user  = usuario;
		this.assignments   = new ArrayList<Tarea>();
	}
	
	public String getCode() { return code; }
	public String getFirst_name() { return first_name; }
	public String getLast_name() { return last_name; }
	public String getGithub_user() { return github_user; }
	public List<Tarea> getAssignments() { return assignments; }

	public void setFirst_name(String nombre) { this.first_name = nombre; }
	public void setLast_name(String apellido) { this.last_name = apellido; }
	public void setCode(String legajo) { this.code = legajo; }
	public void setGithub_user(String usuario) { this.github_user = usuario; }
	public void setAssignments(List<Tarea> tareas) { this.assignments = tareas; }

	public void agregarTarea(Tarea tarea) { this.assignments.add(tarea); }
	
}
