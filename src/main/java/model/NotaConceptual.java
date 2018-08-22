package model;

public class NotaConceptual implements Nota {

	private String nota;

	public NotaConceptual(String nota) { 
		this.nota = nota;
	}

	public String getNota() { return nota; }
	public void setNota(String nota) { this.nota = nota; }

	public boolean estaAprobada() {
		return !this.nota.equals("M");
	}

	@Override
	public String toString() { return this.nota; }
}
