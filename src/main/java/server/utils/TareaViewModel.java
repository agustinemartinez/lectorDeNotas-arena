package server.utils;

import model.Tarea;

public class TareaViewModel {
	
	private String descripcion;
	private String notaActual;
	private String estado;
	
	private TareaViewModel(Tarea tarea) {
		this.descripcion = tarea.getDescripcion();
		if (tarea.getNotas() != null) {
			this.notaActual = tarea.getNotaActual().toString();
			this.estado = tarea.getNotaActual().estaAprobada() ? "Aprobada" : "Desaprobada";			
		}
		else {
			this.notaActual = " - ";
			this.estado = " - ";			
		}
	}

	public String getDescripcion() { return this.descripcion; }
	public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
	public String getEstado() { return estado; }
	public String getNotaActual() { return notaActual; }
	public void setNotaActual(String notaActual) { this.notaActual = notaActual; }
	public void setEstado(String estado) { this.estado = estado; }
	
	public static TareaViewModel convert(Tarea tarea) {
		return new TareaViewModel(tarea);
	}
	
}
