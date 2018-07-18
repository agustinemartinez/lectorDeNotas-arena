package model;

import java.util.ArrayList;
import java.util.List;

public class Tarea {
	
	private String descripcion;
	Nota notaActual;
	private List<Nota> notas;
	
	public Tarea(String descripcion) {
		this.descripcion = descripcion;
		this.notas = new ArrayList<Nota>();
	}

	public String getDescripcion() { return this.descripcion; }
	public List<Nota> getNotas() { return this.notas; }
	public Nota getNotaActual() { return notaActual; }
	public void setNotaActual(Nota notaActual) { this.notaActual = notaActual; }
	
	public void agregarNota(String nota) {
		this.notaActual = new Nota(nota);
		this.notas.add(this.notaActual); 
	}
	
	@Override
	public String toString() { return this.descripcion; }
}