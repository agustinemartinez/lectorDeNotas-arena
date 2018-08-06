package application;

import model.Fixture;
import ui.windows.AlumnoWindow;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

public class LectorDeNotasApplication extends Application {

	public static void main(String[] args) {
		Fixture.inicializar();
		new LectorDeNotasApplication().start();
	}

	@Override
	protected Window<?> createMainWindow() {
		return new AlumnoWindow(this);
	}

}
