package model;

import java.awt.Color;

public class Nota {
	
	private String nota;
	private String estado;
	private Color fondoEstado;

	public Nota(String nota) { 
		this.nota = nota;
		if (this.estaAprobada()) {
			this.estado = "Aprobado";
			this.fondoEstado = Color.GREEN;
		}
		else {
			this.estado = "Desaprobado";
			this.fondoEstado = Color.RED;
		}
	}

	public String getEstado() { return this.estado; }
	public String getNota() { return nota; }
	public Color getFondoEstado() { return this.fondoEstado; }
	public void setEstado(String estado) { this.estado = estado; }
	public void setNota(String nota) { this.nota = nota; }
	public void setFondoEstado(Color fondoEstado) { this.fondoEstado = fondoEstado; }

	public boolean estaAprobada() {
		if (this.nota.chars().allMatch( Character::isDigit ))
			return Integer.parseInt(this.nota) >= 6;
		return !this.nota.equals("M");
	}

	@Override
	public String toString() { return this.nota; }

}
