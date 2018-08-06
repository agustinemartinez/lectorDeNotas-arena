package ui.vm;

import org.uqbar.commons.model.annotations.Observable;

import model.Alumno;

@Observable
public class AlumnoEditarDatosViewModel {
	
	private Alumno alumno;
	private String nombre;
	private String apellido;
	private String usuario;
	
	public AlumnoEditarDatosViewModel(Alumno alumno) {
		this.alumno	  = alumno;
		this.nombre   = alumno.getNombre();
		this.apellido = alumno.getApellido();
		this.usuario  = alumno.getUsuario();
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
		this.alumno.setNombre(this.nombre);
		this.alumno.setApellido(this.apellido);
		this.alumno.setUsuario(this.usuario);
	}
	
}
