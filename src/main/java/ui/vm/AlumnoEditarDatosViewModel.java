package ui.vm;

import org.uqbar.commons.model.annotations.Observable;

import model.Alumno;
import model.repositories.RepoAlumnos;

@Observable
public class AlumnoEditarDatosViewModel {
	
	private Alumno alumno;
	private String nombre;
	private String apellido;
	private String usuario;
	
	public AlumnoEditarDatosViewModel(Alumno alumno) {
		this.alumno	  = alumno;
		this.nombre   = alumno.getFirst_name();
		this.apellido = alumno.getLast_name();
		this.usuario  = alumno.getGithub_user();
	}

	public Alumno getAlumno() { return alumno; }
	public String getNombre() { return nombre; }
	public String getApellido() { return apellido; }
	public String getUsuario() { return usuario; }
	public void setAlumno(Alumno alumno) { this.alumno = alumno; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	public void setApellido(String apellido) { this.apellido = apellido; }
	public void setUsuario(String usuario) { this.usuario = usuario; }	
	
	public void guardarAlumno() {
		this.alumno.setFirst_name(this.nombre);
		this.alumno.setLast_name(this.apellido);
		this.alumno.setGithub_user(this.usuario);
		//RepoAlumnos.guardarAlumno(this.alumno);
	}
	
}
