package ui.windows;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import ui.vm.AlumnoViewModel;

@SuppressWarnings({ "serial", "rawtypes" })
public class ErrorPanelWindow extends Dialog {

	private String message;
	
	@SuppressWarnings("unchecked")
	public ErrorPanelWindow(WindowOwner owner, String message) {
		super(owner, new AlumnoViewModel());
		this.message = message;
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		new Label(mainPanel).setText("ERROR");
		new Label(mainPanel).setText(message);
	}

	@Override
	protected void addActions(Panel actions) {
		
		new Button(actions).setCaption("Aceptar")
						   .onClick(this::cancel)
						   .alignCenter();
	}

}
