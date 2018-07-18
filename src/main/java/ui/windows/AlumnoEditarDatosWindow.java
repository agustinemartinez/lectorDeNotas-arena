package ui.windows;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import ui.vm.AlumnoViewModel;

@SuppressWarnings("serial")
public class AlumnoEditarDatosWindow extends Dialog<AlumnoViewModel> {

	Panel form; 
	TextBox tbNombre, tbApellido, tbUsuario;

	public AlumnoEditarDatosWindow(WindowOwner owner, AlumnoViewModel alumnoVM) { super(owner, alumnoVM); }

	@Override
	protected void createFormPanel(Panel mainPanel) {
		form = new Panel(mainPanel);		

		// DATOS ALUMNO
		new Label(form).setText("Nombre:").alignLeft().setWidth(100);
		tbNombre = new TextBox(form);
		tbNombre.bindValueToProperty("alumnoSeleccionado.nombre");
		
		new Label(form).setText("Apellido:").alignLeft().setWidth(100);
		tbApellido = new TextBox(form);
		tbApellido.bindValueToProperty("alumnoSeleccionado.apellido");

		new Label(form).setText("Usuario:").alignLeft().setWidth(100);
		tbUsuario = new TextBox(form);
		tbUsuario.bindValueToProperty("alumnoSeleccionado.usuario");
		
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Guardar").onClick(this::accept);
		new Button(actions).setCaption("Cancelar").onClick(this::cancel);
	}
	
}
