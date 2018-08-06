package model;

import model.repositories.Repositorios;

public class Fixture {
	
	public static void inicializar() {
		
		Alumno juanPerez = new Alumno("1","Juan","Perez","juanPerez");
		Tarea parcial1 = new Tarea("Parcial 1");
		parcial1.agregarNota("2");
		parcial1.agregarNota("6");
		Tarea parcial2 = new Tarea("Parcial 2");
		parcial2.agregarNota("3");
		Tarea tpA = new Tarea("TP A");
		tpA.agregarNota("B+");
		juanPerez.agregarTarea(parcial1);
		juanPerez.agregarTarea(parcial2);
		juanPerez.agregarTarea(tpA);

		Alumno alu = new Alumno("2","Alu","Alu","alualu");
		Tarea parcial3 = new Tarea("Parcial 3");
		parcial3.agregarNota("3");
		Tarea tpB = new Tarea("TP B");
		tpB.agregarNota("M");
		alu.agregarTarea(parcial3);
		alu.agregarTarea(tpB);
		
		Repositorios.alumnos.agregarAlumno(juanPerez);
		Repositorios.alumnos.agregarAlumno(alu);
	}
	
}
