package domain;

import model.Alumno;
import model.Tarea;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class LectorDeNotasTest {

	@Test
	public void testAlumnoAprobado() {
		Alumno alumno = new Alumno();
		alumno.setNombre("pepe");
		alumno.setApellido("sanchez");
		alumno.setLegajo(1251058);
		alumno.setUsuario("lukaku");
		Tarea tarea1 = new Tarea("fisica", Arrays.asList("1","7"));
		assertEquals(true,tarea1.getAprobada());
	}
	
	@Test
	public void testAlumnoDesprobado() {
		Alumno alumno = new Alumno();
		alumno.setNombre("Agustin");
		alumno.setApellido("Martinez");
		alumno.setLegajo(125213);
		alumno.setUsuario("cuco");
		Tarea tarea1 = new Tarea("ingenieria y sociedad", Arrays.asList("1","4"));
		assertEquals(false,tarea1.getAprobada());
	}

}
