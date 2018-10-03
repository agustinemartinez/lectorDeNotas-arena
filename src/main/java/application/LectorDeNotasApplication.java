package application;

import model.Alumno;
import model.Fixture;
import server.RequestService;
import ui.windows.AlumnoWindow;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

public class LectorDeNotasApplication {//extends Application {

	public static void main(String[] args) {
		
		Alumno a = new RequestService().getAlumno("111222333");

		System.out.println(a.getCode());    		
 		System.out.println(a.getFirst_name());    		
 		System.out.println(a.getLast_name());    		
 		System.out.println(a.getGithub_user());    		

//		Fixture.inicializar();
//		new LectorDeNotasApplication().start();
//	}
//
//	@Override
//	protected Window<?> createMainWindow() {
//		return new AlumnoWindow(this);
	}

}
