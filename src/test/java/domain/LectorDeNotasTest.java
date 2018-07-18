package domain;

import model.Alumno;
import model.Tarea;

import static org.junit.Assert.*;
import org.junit.Test;

public class LectorDeNotasTest {

	@Test
	public void testAlumnoAprobado() {
		Tarea tarea1 = new Tarea("fisica").agregarNota("1")
										  .agregarNota("7");
		assertEquals(true, tarea1.getNotaActual().estaAprobada());
	}
	
	@Test
	public void testAlumnoDesprobado() {
		Alumno alumno = new Alumno("10", "Nicolas", "Calle", "riBer");
		Tarea tarea1 = new Tarea("ingenieria y sociedad").agregarNota("2")
														 .agregarNota("4");
		alumno.agregarTarea(tarea1);
		assertEquals(false, alumno.getTareas().get(0).getNotaActual().estaAprobada());
	}

}
