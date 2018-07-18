package ui.windows;

import java.awt.Color;

import model.Tarea;

import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.NumericField;

import ui.vm.AlumnoViewModel;

@SuppressWarnings("serial")
public class AlumnoWindow extends SimpleWindow<AlumnoViewModel> {

	Panel mainPanel, panelIzq, panelMedio, panelDer;
	Label lbNombre, lbApellido, lbUsuario, lbNota, lbEstado;
	NumericField nfLegajo;
	Selector<Tarea> cbTareas;

	public AlumnoWindow(WindowOwner parent) { super(parent, new AlumnoViewModel()); }

	@Override
	protected void createFormPanel(Panel formPanel) {
		
		this.setTitle("Lector de Notas");
		mainPanel = new Panel(formPanel).setLayout(new ColumnLayout(3));
		
		panelIzq   = new Panel(mainPanel);		
		panelMedio = new Panel(mainPanel);
		panelDer   = new Panel(mainPanel);

		// LEGAJO
		new Label(panelIzq).setText("Legajo").alignLeft();
		nfLegajo = new NumericField(panelIzq);
		nfLegajo.setWidth(75);
		nfLegajo.bindValueToProperty("legajoIngresado");

		// DATOS ALUMNO
		new Label(panelMedio).setText("Nombre:").alignLeft().setWidth(150);
		lbNombre = new Label(panelMedio);
		lbNombre.bindValueToProperty("alumnoSeleccionado.nombre");
		
		new Label(panelMedio).setText("Apellido:").alignLeft().setWidth(150);
		lbApellido = new Label(panelMedio);
		lbApellido.bindValueToProperty("alumnoSeleccionado.apellido");

		new Label(panelMedio).setText("Usuario:").alignLeft().setWidth(150);
		lbUsuario = new Label(panelMedio);
		lbUsuario.bindValueToProperty("alumnoSeleccionado.usuario");
		
		// TAREAS ALUMNO
		new Label(panelDer).setText("Tareas").alignLeft();
		cbTareas = new Selector<Tarea>(panelDer);
		cbTareas.setWidth(100);
		cbTareas.bindItemsToProperty("alumnoSeleccionado.tareas");
		cbTareas.bindValueToProperty("tareaSeleccionada");

		new Label(panelDer).setText("Nota").alignLeft();
		lbNota = new Label(panelDer);
		lbNota.bindValueToProperty("tareaSeleccionada.notaActual");
		
		new Label(panelDer).setText("Estado").alignLeft();
		lbEstado = new Label(panelDer);
		lbEstado.setBackground(Color.GRAY);
		lbEstado.bindValueToProperty("tareaSeleccionada.notaActual.estado");
	}
	
	@Override
	protected void addActions(Panel panelActions) {
		new Button(panelIzq).setCaption("Buscar")
							.onClick(()-> {
								try { this.getModelObject().cargarAlumno(); }
								catch(IndexOutOfBoundsException ex) { 
									this.messageAlumnoInexistente();
									//ex.printStackTrace(); 
								}
							})
							.setWidth(75);		

		new Button(panelIzq).setCaption("Editar")
							.onClick(()-> {
								if(this.getModelObject().getAlumnoSeleccionado().getLegajo().length() > 0)
									this.editarDatos();
							});
	}

	private void editarDatos() {
		Dialog<?> dialog = new AlumnoEditarDatosWindow(this, this.getModelObject());
		dialog.onAccept(() -> {});
		dialog.open();
	}

	private void messageAlumnoInexistente() {
		ErrorPanelWindow errorWindow = new ErrorPanelWindow(this, "Alumno inexistente");
		errorWindow.onAccept(() -> {});
		errorWindow.open();
	}

}
