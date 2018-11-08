package request;

import java.util.List;

import request.dto.TareasDTO;
import model.Alumno;
import model.Tarea;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RequestService {
	
    private static final String NOTITAS_SERVER_STUDENT = "http://notitas.herokuapp.com/student";
    private static final String NOTITAS_SERVER_STUDENT_ASSIGNMENTS = "http://notitas.herokuapp.com/student/assignments";
    private static final String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";
	private Client client;
    private ObjectMapper mapper = new ObjectMapper().enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
    												.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

    public RequestService() {
        this.client = Client.create();
    }

    public Alumno getAlumno(String legajo) {
    	try {
        	WebResource.Builder webResource = client.resource(NOTITAS_SERVER_STUDENT)
        											.queryParam("code", legajo)
        											.header("AUTHORIZATION", "Bearer " + TOKEN);
        											
        	ClientResponse response = webResource.accept("application/json")
        										 .get(ClientResponse.class);

        	if (response.getStatus() != 200)
     		   throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());

     		String output = response.getEntity(String.class);
     		Alumno alumno = mapper.readValue( output , Alumno.class );
     		alumno.setAssignments(this.getTareas());

     		return alumno;
    	} 
    	catch (Exception e) {
 			e.printStackTrace();    	
 			return null;
    	}
    }
    
    public void putAlumno(Alumno alumno) {
    	try {
    		String body = mapper.writeValueAsString(alumno);
        	WebResource.Builder webResource = client.resource(NOTITAS_SERVER_STUDENT)
													.queryParam("code", alumno.getCode())
        											.header("AUTHORIZATION", "Bearer " + TOKEN);
        											
        	ClientResponse response = webResource.accept("application/json")
        										 .put(ClientResponse.class, body);

        	if (response.getStatus() != 201)
     		   throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
    	} 
    	catch (Exception e) {
 			e.printStackTrace();    	
    	}    	
    }
    
    private List<Tarea> getTareas() {
    	try {
        	WebResource.Builder webResource = client.resource(NOTITAS_SERVER_STUDENT_ASSIGNMENTS)
        											.header("AUTHORIZATION", "Bearer " + TOKEN);
        											
        	ClientResponse response = webResource.accept("application/json")
        										 .get(ClientResponse.class);
        	
        	if (response.getStatus() != 200)
     		   throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());

     		String output = response.getEntity(String.class);
     		return mapper.readValue( output , TareasDTO.class ).getAssignments();
    	} 
    	catch (Exception e) {
 			e.printStackTrace();	
 			return null;
    	}
    }

    
}
