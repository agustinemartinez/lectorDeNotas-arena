package model;

import java.util.List;

public class Usuario {

	private static String user;
	private String password;
	private static List<Tarea> tareas;
	
	public Usuario() { }

	public Usuario(String user, String password) {
		this.user = user;
		this.password = password;
	}
	
	public static String getUser() { return user; }
	public static List<Tarea> getTareas() {return tareas;}
	
	public void setUser(String user) { this.user = user; }
	public void setPassword(String password) { this.password = password; }

	public boolean correctPassword(String password) {
		return this.password.equals(password);
	}
	
}
