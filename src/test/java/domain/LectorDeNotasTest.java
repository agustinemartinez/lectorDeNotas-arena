package domain;

import model.Alumno;
import model.Fixture;
import model.NotaNumerica;
import model.Tarea;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.awt.Color;

import ui.vm.AlumnoViewModel;

public class LectorDeNotasTest {

	@Before
	public void init() {
		Fixture.inicializar();
	}
	
	@Test
	public void testTareaAprobada() {
		Tarea tarea1 = new Tarea("fisica").agregarNota(new NotaNumerica(2))
										  .agregarNota(new NotaNumerica(7));
		assertTrue(tarea1.getNotaActual().estaAprobada());
	}
	
	@Test
	public void testAlumnoAprobado() {
		Alumno alumno = new Alumno("10", "Nicolas", "Calle", "river");
		Tarea tarea1 = new Tarea("ingenieria y sociedad").agregarNota(new NotaNumerica(8))
														 .agregarNota(new NotaNumerica(8));
		alumno.agregarTarea(tarea1);
		assertFalse(alumno.getAssignments().get(0).getNotaActual().estaAprobada());
	}

	@Test
	public void testLegajoIngresadoEsDeJuanPerez() {
		AlumnoViewModel modelObject = new AlumnoViewModel();
		modelObject.setLegajoIngresado("1");
		modelObject.cargarAlumno();
		assertEquals("Juan" , modelObject.getAlumnoSeleccionado().getFirst_name());
		assertEquals("Perez", modelObject.getAlumnoSeleccionado().getLast_name());
	}

	@Test
	public void testObtenerNotaActualDeTareaAPartirDeListaDeNotas() {
		Tarea tarea = new Tarea("Una Tarea");
		tarea.agregarNota(new NotaNumerica(1))
			 .agregarNota(new NotaNumerica(2))
			 .agregarNota(new NotaNumerica(3));
		assertEquals("3", tarea.getNotaActual().toString());
	}

	@Test
	public void testColorDeNotaAprobada() {
		AlumnoViewModel modelObject = new AlumnoViewModel();
		Tarea tareaAprobada = new Tarea("Una Tarea Aprobada").agregarNota(new NotaNumerica(9));
		modelObject.setTareaSeleccionada(tareaAprobada);
		assertEquals(Color.GREEN, modelObject.getFondoEstadoTarea());
	}

}
