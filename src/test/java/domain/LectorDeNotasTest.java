package domain;

import model.Alumno;
import model.Fixture;
import model.Tarea;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ui.vm.AlumnoViewModel;

public class LectorDeNotasTest {

	@Before
	public void init() {
		Fixture.inicializar();
	}
	
	@Test
	public void testTareaAprobada() {
		Tarea tarea1 = new Tarea("fisica").agregarNota("1")
										  .agregarNota("7");
		assertTrue(tarea1.getNotaActual().estaAprobada());
	}
	
	@Test
	public void testAlumnoDesprobado() {
		Alumno alumno = new Alumno("10", "Nicolas", "Calle", "riBer");
		Tarea tarea1 = new Tarea("ingenieria y sociedad").agregarNota("2")
														 .agregarNota("4");
		alumno.agregarTarea(tarea1);
		assertFalse(alumno.getTareas().get(0).getNotaActual().estaAprobada());
	}

	@Test
	public void testLegajoIngresadoEsDeJuanPerez() {
		AlumnoViewModel modelObject = new AlumnoViewModel();
		modelObject.setLegajoIngresado("1");
		modelObject.cargarAlumno();
		assertEquals("Juan" , modelObject.getAlumnoSeleccionado().getNombre());
		assertEquals("Perez", modelObject.getAlumnoSeleccionado().getApellido());
	}

}
