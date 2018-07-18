package ui.windows;

import ui.vm.AlumnoEditarDatosViewModel;
import model.Alumno;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

@SuppressWarnings("serial")
public class AlumnoEditarDatosWindow extends Dialog<AlumnoEditarDatosViewModel> {

	Panel form; 
	TextBox tbNombre, tbApellido, tbUsuario;

	public AlumnoEditarDatosWindow(WindowOwner owner, Alumno alumno) { super(owner, new AlumnoEditarDatosViewModel(alumno)); }

	@Override
	protected void createFormPanel(Panel mainPanel) {
		form = new Panel(mainPanel);		

		// DATOS ALUMNO
		new Label(form).setText("Nombre:").alignLeft().setWidth(100);
		tbNombre = new TextBox(form);
		tbNombre.bindValueToProperty("nombre");
		
		new Label(form).setText("Apellido:").alignLeft().setWidth(100);
		tbApellido = new TextBox(form);
		tbApellido.bindValueToProperty("apellido");

		new Label(form).setText("Usuario:").alignLeft().setWidth(100);
		tbUsuario = new TextBox(form);
		tbUsuario.bindValueToProperty("usuario");
		
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Guardar")
						   .onClick(()-> {
							   this.getModelObject().guardarAlumno();
							   this.accept();
						   });
		new Button(actions).setCaption("Cancelar").onClick(this::cancel);
	}
	
}
