package model;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.annotations.Observable;

@Observable
public class Tarea {
	
	private String descripcion;
	private List<Nota> notas;
	
	public Tarea(String descripcion) {
		this.descripcion = descripcion;
		this.notas = new ArrayList<Nota>();
	}

	public String getDescripcion() { return this.descripcion; }
	public List<Nota> getNotas() { return this.notas; }
	public void setNotas(List<Nota> notas) { this.notas = notas; }
	
	public Nota getNotaActual() { 
		return notas.size()>0?notas.get(notas.size()-1):notas.get(0); 
	}
	
	public Tarea agregarNota(Nota nota) {
		this.notas.add(nota); 
		return this;
	}
	
	@Override
	public String toString() { return this.descripcion; }
}