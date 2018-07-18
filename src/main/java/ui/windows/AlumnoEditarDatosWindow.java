package ui.windows;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import ui.vm.AlumnoEditarDatosViewModel;

@SuppressWarnings("serial")
public class AlumnoEditarDatosWindow extends Dialog<AlumnoEditarDatosViewModel> {

	public AlumnoEditarDatosWindow(WindowOwner owner) { super(owner, new AlumnoEditarDatosViewModel()); }

	@Override
	protected void createFormPanel(Panel arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
