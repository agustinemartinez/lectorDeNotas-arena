package ui.windows;

import java.awt.Color;

import model.Tarea;

import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.MainWindow;
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

	public AlumnoWindow(WindowOwner parent) { super(parent, new AlumnoViewModel()); }

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Lector de Notas");
		mainPanel.setLayout(new ColumnLayout(2));
		
		Panel panelIzq, panelDer;
		Label nombre, apellido, usuario, nota, estado;
		NumericField legajo;
		Selector<Tarea> tareas;

		panelIzq   = new Panel(mainPanel);		
		//panelMedio = new Panel(mainPanel);
		panelDer   = new Panel(mainPanel);

		// LEGAJO
		new Label(panelIzq).setText("Legajo").alignLeft();
		legajo = new NumericField(panelIzq);
		legajo.setWidth(75);
		legajo.bindValueToProperty("legajoIngresado");

		// DATOS ALUMNO
		nombre = new Label(panelIzq).setText("Nombre: " + this.getModelObject().getAlumnoSeleccionado().getNombre());
		nombre.alignLeft().setWidth(100);

		apellido = new Label(panelIzq).setText("Apellido: " + this.getModelObject().getAlumnoSeleccionado().getApellido());
		apellido.alignLeft().setWidth(100);

		usuario = new Label(panelIzq).setText("Usuario: " + this.getModelObject().getAlumnoSeleccionado().getUsuario());
		usuario.alignLeft().setWidth(100);
		
		new Button(panelIzq)
		.setCaption("Buscar")
		.onClick(()-> {
			try { this.getModelObject().cargarAlumno(); }
			catch(IndexOutOfBoundsException ex) { ex.printStackTrace(); } // Ventana de error
		});


//		nombre.bindValueToProperty("nombre");
//		nombre.bindEnabledToProperty("nombre");
		
//		new Label(panelMedio).setText("Apellido").alignLeft().setWidth(100);
//		apellido = new TextBox(panelMedio);
//		apellido.bindValueToProperty("apellido");

//		new Label(panelMedio).setText("Usuario").alignLeft().setWidth(100);
//		usuario = new TextBox(panelMedio);
//		usuario.bindValueToProperty("usuario");

		// TAREAS ALUMNO
		new Label(panelDer).setText("Tareas").alignLeft();
		tareas = new Selector<Tarea>(panelDer);
		tareas.setWidth(100);
		//tareas.bindItemsToProperty("alumnoSeleccionado.tareas");
		//tareas.bindValueToProperty("tareaSeleccionada");

		new Label(panelDer).setText("Nota").alignLeft();
		nota = new Label(panelDer);
		//nota.bindValueToProperty("tareaSeleccionada.notaActual");
		
		new Label(panelDer).setText("Estado").alignLeft();
		estado = new Label(panelDer);
		//estado.setBackground(Color.GRAY);
		//estado.bindValueToProperty("tareaSeleccionada.notaActual.aprobada");

//		new Button(panelMedio)
//			.setCaption("Editar")
//			.onClick(()-> this.getModelObject().editarDatos());
		
//		tareas.onSelection(() -> { 
//			tareas.bindValueToProperty("tareaSeleccionada");
//		});

	}
	
	@Override
	protected void addActions(Panel panelActions) {
	}

//	public void editarDatos() {
//		Dialog<?> dialog = new AlumnoEditarDatosWindow(this);
//		//dialog.onAccept(() -> getModelObject().setDatosAlumno(Repositorios.alumnos.all()));
//		dialog.open();
//	}
	
}
