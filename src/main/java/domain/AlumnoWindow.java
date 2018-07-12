package domain;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import org.eclipse.swt.layout.RowLayout;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.arena.filters.TextFilter;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Widget;

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
		nota = new Label(panelDer).setText("-");
		
		new Label(panelDer).setText("Estado").alignLeft();
		estado = new Label(panelDer).setText("-");
		estado.setBackground(Color.GRAY);
		//.bindBackgroundToProperty(propertyName);
		
		// BOTONES
		new Button(panelIzq)
			.setCaption("Buscar")
			.onClick(()-> this.getModelObject().cargarDatos());

		new Button(panelMedio)
			.setCaption("Guardar cambios")
			.onClick(()-> this.getModelObject().guardarCambios());
		
		tareas.onSelection(() -> { 
			System.out.println(this.getModelObject().getTareaSeleccionada());
			//nota.bindValueToProperty("tareaSeleccionada.notaActual");
			//this.getModelObject().getTareaSeleccionada().toString(); //.notaActual());
			//estado.bindBackgroundToProperty("aprobada");
//			if (this.getModelObject().getTareaSeleccionada().getAprobada())
//				estado.setText("Aprobada");
//			else
//				estado.setText("Desaprobada");				
		});
	}
	
	public static void main(String[] args) {
		new AlumnoWindow().startApplication();
	}
}
