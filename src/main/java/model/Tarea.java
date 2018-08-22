package model;

import java.util.ArrayList;
import java.util.List;

public class Tarea {
	
	private String descripcion;
	private List<Nota> notas;
	
	public Tarea(String descripcion) {
		this.descripcion = descripcion;
		this.notas = new ArrayList<Nota>();
	}

	public String getDescripcion() { return this.descripcion; }
	public List<Nota> getNotas() { return this.notas; }
	
	public Nota getNotaActual() { 
		return this.notas.get(this.notas.size()-1); 
	}
	
	public Tarea agregarNota(Nota nota) {
		this.notas.add(nota); 
		return this;
	}
	
	@Override
	public String toString() { return this.descripcion; }
}