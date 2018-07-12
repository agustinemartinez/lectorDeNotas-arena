package domain;

import java.util.List;

public class Tarea {
	String nombre;
	List<String> notas;
	
	public Tarea(String nombre, List<String> notas) {
		this.nombre = nombre;
		this.notas = notas;
	}

	public String getNombre() { return nombre; }
	public List<String> getNotas() { return notas; }

	public String notaActual() {
		return notas.get(notas.size()-1);
	}

	public boolean getAprobada() {
		if (this.notaActual().chars().allMatch( Character::isDigit ))
			return Integer.parseInt(this.notaActual()) > 6;
		return !this.notaActual().equals("M");
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}
}
