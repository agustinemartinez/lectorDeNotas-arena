package ui.vm;

import model.Alumno;
import model.Tarea;
import model.repositories.RepoAlumnos;

import org.uqbar.commons.model.annotations.Observable;

@Observable
public class AlumnoViewModel {
		long legajo;
		Alumno alumno;
		Tarea tareaSeleccionada;
		String notaActual;
		String estado;
		
		public Tarea getTareaSeleccionada() { return tareaSeleccionada; }
		public void setTareaSeleccionada(Tarea tareaSeleccionada) { this.tareaSeleccionada = tareaSeleccionada; }

		public long getLegajo() {
			return legajo;
		}
		public void setLegajo(long legajo) {
			this.legajo = legajo;
		}
		public Alumno getAlumno() {
			return alumno;
		}
		public void setAlumno(Alumno alumno) {
			this.alumno = alumno;
		}
		public String getNotaActual() {
			return notaActual;
		}
		public void setNotaActual(String notaActual) {
			this.notaActual = notaActual;
		}
		public String getEstado() {
			return estado;
		}
		public void setEstado(String estado) {
			this.estado = estado;
		}
//		
//		public void cargarDatos() {
//			try {
//				Alumno a = RepoAlumnos.getInstance().getAlumno(this.legajo);
//				alumno.nombre   = a.getNombre();
//				alumno.apellido = a.getApellido();
//				alumno.legajo   = a.getLegajo();
//				alumno.usuario  = a.getUsuario();
//				alumno.tareas   = a.getTareas();
//				this.tareaSeleccionada = alumno.getTareas().get(0);
//				this.notaActual = this.tareaSeleccionada.getNotaActual();
//				this.estado = this.tareaSeleccionada.getAprobada()?"Aprobada":"Desaprobada";
//			}
//			catch(IndexOutOfBoundsException e) { 
//				alumno.nombre   = "";
//				alumno.apellido = "";
//				alumno.usuario  = "";
//				alumno.tareas   = null;
//				this.tareaSeleccionada = null; 
//				this.notaActual = "-";
//				this.estado = "-";
//			}
//		}
//		
		public void guardarCambios() {
			RepoAlumnos.getInstance().setAlumno(alumno);
		}	

}
