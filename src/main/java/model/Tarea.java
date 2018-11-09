package model;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.annotations.Observable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Observable
@JsonIgnoreProperties(value = { "changeSupport" })
public class Tarea {
	
	private long id;
	@JsonProperty("title")
	private String titulo;
	@JsonProperty("description")
	private String descripcion;
	@JsonProperty("grades")
	private List<Nota> notas;
	
	public Tarea() { }
	
	public Tarea(String descripcion) {
		this.descripcion = descripcion;
		this.notas = new ArrayList<Nota>();
	}

	public long getId() { return this.id; }
	public String getTitulo() { return this.titulo; }
	public String getDescripcion() { return this.descripcion; }
	public List<Nota> getNotas() { return this.notas; }
	public void setId(long id) { this.id = id; }
	public void setTitulo(String titulo) { this.titulo = titulo; }
	public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
	public void setNotas(List<Nota> notas) { this.notas = notas; }
	
	public Nota getNotaActual() { 
		return notas.size()>0 ? notas.get(notas.size()-1) : notas.get(0); 
	}
	
	public Tarea agregarNota(Nota nota) {
		this.notas.add(nota); 
		return this;
	}
	
	@Override
	public String toString() { return this.descripcion; }
}
