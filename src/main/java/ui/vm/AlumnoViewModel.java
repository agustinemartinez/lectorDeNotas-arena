package ui.vm;

import java.awt.Color;

import model.Alumno;
import model.NotaConceptual;
import model.Tarea;
import model.repositories.Repositorios;

import org.apache.commons.collections15.Transformer;
import org.uqbar.commons.model.annotations.Observable;

@Observable
public class AlumnoViewModel {

	private String legajoIngresado;
	private Alumno alumnoSeleccionado;
	private Tarea tareaSeleccionada;
	private String estadoTarea;
	private Color fondoEstadoTarea;
	private Transformer<Tarea, Color> transformer = new Transformer<Tarea, Color>() {
        @Override
        public Color transform(Tarea tarea) {
            if (estadoTarea.equals("-"))
                return Color.GRAY;            	
            else if (tarea.getNotaActual().estaAprobada())
            	return Color.GREEN;
            else
                return Color.RED;
        }
    };

	public AlumnoViewModel() { 
		this.alumnoSeleccionado = new Alumno("", "", "", "");
		this.limpiarEstadoTarea();
	}

	public Alumno getAlumnoSeleccionado() { return this.alumnoSeleccionado; }
	public Tarea getTareaSeleccionada() { return this.tareaSeleccionada; }
	public String getLegajoIngresado() { return this.legajoIngresado; }
	public String getEstadoTarea() { return this.estadoTarea; }
	public Color getFondoEstadoTarea() { return this.fondoEstadoTarea; }
	public void setAlumnoSeleccionado(Alumno alumnoSeleccionado) { this.alumnoSeleccionado = alumnoSeleccionado; }
	public void setLegajoIngresado(String legajoIngresado) { this.legajoIngresado = legajoIngresado; }

	public void setTareaSeleccionada(Tarea tareaSeleccionada) { 
		if (tareaSeleccionada != null && tareaSeleccionada.getNotas() != null) {
			this.tareaSeleccionada = tareaSeleccionada; 
			if (tareaSeleccionada.getNotaActual().estaAprobada())
				this.estadoTarea = "Aprobado";
			else
				this.estadoTarea = "Desaprobado";
			this.fondoEstadoTarea = transformer.transform(tareaSeleccionada);			
		}
		else
			this.limpiarEstadoTarea();
	}	

	public void cargarAlumno() {
		this.alumnoSeleccionado = Repositorios.alumnos.getAlumno(legajoIngresado);				
		this.limpiarEstadoTarea();
	}

	private void limpiarEstadoTarea() {
		this.tareaSeleccionada = new Tarea("").agregarNota(new NotaConceptual("-"));
		this.estadoTarea = "-";
		this.fondoEstadoTarea = transformer.transform(tareaSeleccionada);
	}
	
}
