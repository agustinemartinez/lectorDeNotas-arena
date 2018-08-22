package model;

public class NotaNumerica implements Nota {
	
	private int nota;

	public NotaNumerica(int nota) { 
		this.nota = nota;
	}

	public int getNota() { return nota; }
	public void setNota(int nota) { this.nota = nota; }

	public boolean estaAprobada() {
		return this.nota >= 6;
	}

	@Override
	public String toString() { return Integer.toString(this.nota); }

}
