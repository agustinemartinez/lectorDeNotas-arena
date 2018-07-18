package model;

public class Nota {
	
	private String nota;
	private boolean aprobada;
	
	public Nota(String nota) { 
		this.nota = nota; 
		this.setAprobada(this.estaAprobada());
	}

	public boolean isAprobada() { return aprobada; }
	public void setAprobada(boolean aprobada) { this.aprobada = aprobada; }

	public boolean estaAprobada() {
		if (this.nota.chars().allMatch( Character::isDigit ))
			return Integer.parseInt(this.nota) >= 6;
		return !this.nota.equals("M");
	}

}
