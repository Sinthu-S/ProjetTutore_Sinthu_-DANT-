package models;

import org.springframework.data.annotation.Id;

public class Message {
	
	@Id
	private String id;
	
	public String auteur;
	public String message;
	
	public Message(String auteur, String message) {
		super();
		this.auteur = auteur;
		this.message = message;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
	

}
