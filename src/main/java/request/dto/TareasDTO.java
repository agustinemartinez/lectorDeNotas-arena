package request.dto;

import java.util.List;

import model.Tarea;

public class TareasDTO {

	private List<Tarea> assignments;

	public TareasDTO() { }
	
	public List<Tarea> getAssignments() { 
		assignments.forEach( a -> {
			if(a.getNotas().isEmpty())
				a.setNotas(null);
		});
		return assignments;
	}
	public void setAssignments(List<Tarea> assignments) { this.assignments = assignments; }
	
}
