package ui.windows;

import java.awt.Color;

import model.Alumno;
import model.Tarea;

import org.uqbar.arena.windows.MainWindow;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.NumericField;

@SuppressWarnings("serial")
public class AlumnoWindow extends MainWindow<Alumno> {

	public AlumnoWindow() { super(new Alumno()); }

	@Override
	public void createContents(Panel mainPanel) {
		this.setTitle("Lector de Notas");
		mainPanel.setLayout(new ColumnLayout(3));
		
		TextBox nombre, apellido, usuario;
		Selector<Tarea> tareas;
		Label nota, estado;
		
		Panel panelIzq   = new Panel(mainPanel);		
		Panel panelMedio = new Panel(mainPanel);
		Panel panelDer   = new Panel(mainPanel);

		// LEGAJO
		new Label(panelIzq).setText("Legajo").alignLeft();
		NumericField legajo = new NumericField(panelIzq);
		legajo.setWidth(75);
		legajo.bindValueToProperty("legajo");

		// DATOS ALUMNO
		new Label(panelMedio).setText("Nombre").alignLeft().setWidth(100);
		nombre = new TextBox(panelMedio);
		nombre.bindValueToProperty("nombre");
		nombre.bindEnabledToProperty("nombre");
		
		new Label(panelMedio).setText("Apellido").alignLeft().setWidth(100);
		apellido = new TextBox(panelMedio);
		apellido.bindValueToProperty("apellido");

		new Label(panelMedio).setText("Usuario").alignLeft().setWidth(100);
		usuario = new TextBox(panelMedio);
		usuario.bindValueToProperty("usuario");

		// TAREAS ALUMNO
		new Label(panelDer).setText("Tareas").alignLeft();
		tareas = new Selector<Tarea>(panelDer);
		tareas.setWidth(100);
		tareas.bindItemsToProperty("tareas");
		tareas.bindValueToProperty("tareaSeleccionada");

		new Label(panelDer).setText("Nota").alignLeft();
		nota = new Label(panelDer);//.setText("-");
		nota.bindValueToProperty("nota");
		
		new Label(panelDer).setText("Estado").alignLeft();
		estado = new Label(panelDer);//.setText("-");
		estado.setBackground(Color.GRAY);
		estado.bindValueToProperty("aprobada");
		
		// BOTONES
		new Button(panelIzq)
			.setCaption("Buscar")
			.onClick(()-> this.getModelObject().cargarDatos());

		new Button(panelMedio)
			.setCaption("Guardar cambios")
			.onClick(()-> this.getModelObject().guardarCambios());
		
		tareas.onSelection(() -> { 
			tareas.bindValueToProperty("tareaSeleccionada");
		});
	}
	
}
