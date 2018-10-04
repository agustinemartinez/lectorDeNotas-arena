package ui.windows;

import model.Tarea;
import ui.vm.AlumnoViewModel;

import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.NumericField;

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
		lbNombre.bindValueToProperty("alumnoSeleccionado.first_name");
		
		new Label(panelMedio).setText("Apellido:").alignLeft().setWidth(150);
		lbApellido = new Label(panelMedio);
		lbApellido.bindValueToProperty("alumnoSeleccionado.last_name");

		new Label(panelMedio).setText("Usuario:").alignLeft().setWidth(150);
		lbUsuario = new Label(panelMedio);
		lbUsuario.bindValueToProperty("alumnoSeleccionado.github_user");
		
		// TAREAS ALUMNO
		new Label(panelDer).setText("Tareas").alignLeft();
		cbTareas = new Selector<Tarea>(panelDer);
		cbTareas.setWidth(100);
		cbTareas.bindItemsToProperty("alumnoSeleccionado.assignments");
		cbTareas.bindValueToProperty("tareaSeleccionada");

		new Label(panelDer).setText("Nota").alignLeft();
		lbNota = new Label(panelDer);
		lbNota.bindValueToProperty("tareaSeleccionada.notaActual");
		
		new Label(panelDer).setText("Estado").alignLeft();
		lbEstado = new Label(panelDer);
		lbEstado.bindValueToProperty("estadoTarea");
		lbEstado.bindBackgroundToProperty("fondoEstadoTarea");
	}
	
	@Override
	protected void addActions(Panel panelActions) {
		new Button(panelIzq).setCaption("Buscar")
							.onClick(()-> {
								try { this.getModelObject().cargarAlumno(); }
								catch(Exception ex) { this.messageAlumnoInexistente(); }
							})
							.setWidth(75);		

		new Button(panelIzq).setCaption("Editar")
							.onClick(()-> {
								if(this.getModelObject().getAlumnoSeleccionado().getCode().length() > 0)
									this.editarDatos();
							});
	}

	private void editarDatos() {
		Dialog<?> dialog = new AlumnoEditarDatosWindow(this, this.getModelObject().getAlumnoSeleccionado());
		dialog.onAccept(() -> {});
		dialog.open();
	}

	private void messageAlumnoInexistente() {
		ErrorPanelWindow errorWindow = new ErrorPanelWindow(this, "Alumno inexistente");
		errorWindow.onAccept(() -> {});
		errorWindow.open();
	}

}
