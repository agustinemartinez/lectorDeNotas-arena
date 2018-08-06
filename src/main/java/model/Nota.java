package model;

public class Nota {
	
	private String nota;

	public Nota(String nota) { 
		this.nota = nota;
	}

	public String getNota() { return nota; }
	public void setNota(String nota) { this.nota = nota; }

	public boolean estaAprobada() {
		if (this.nota.chars().allMatch( Character::isDigit ))
			return Integer.parseInt(this.nota) >= 6;
		return !this.nota.equals("M");
	}

	@Override
	public String toString() { return this.nota; }

}
