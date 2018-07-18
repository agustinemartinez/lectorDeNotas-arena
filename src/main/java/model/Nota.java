package model;

public class Nota {
	
	private String nota;
	private String estado;
	
	public Nota(String nota) { 
		this.nota = nota;
		if (this.estaAprobada())
			this.estado = "Aprobado";
		else
			this.estado = "Desaprobado";
	}

	public String getEstado() { return this.estado; }
	public String getNota() { return nota; }
	public void setEstado(String estado) { this.estado = estado; }
	public void setNota(String nota) { this.nota = nota; }

	private boolean estaAprobada() {
		if (this.nota.chars().allMatch( Character::isDigit ))
			return Integer.parseInt(this.nota) >= 6;
		return !this.nota.equals("M");
	}

	@Override
	public String toString() { return this.nota; }

}
