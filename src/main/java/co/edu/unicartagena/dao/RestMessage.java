package co.edu.unicartagena.dao;

public class RestMessage {
	
	private String message;
	
	public RestMessage(String description){
		
		//TODO Recibir el id del mensaje, para consultarlo en BD y mostrar el mensaje correcto.
		
		this.message = description;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String description) {
		this.message = description;
	}
	
}
