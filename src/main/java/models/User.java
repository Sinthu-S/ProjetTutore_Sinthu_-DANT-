package models;

import java.util.*;

import org.springframework.data.annotation.Id;

public class User {
	@Id
	private String login;
	
	private String nom;
	private String prenom;
	private String service;
	private String typeUser;
	private String email;
	private String pass;
	public List<String> idProjet;
	public List<Message> notifications;
	public String token;

	public User(){
		super();
	}
	
	



	public User(String nom, String prenom, String service,
			String typeUser,String email, String login, String pass, List<String> idProjet,
			List<Message> notifacations) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.service = service;
		this.typeUser = typeUser;
		this.email = email;
		this.login = login;
		this.pass = pass;
		this.idProjet = idProjet;
		this.notifications = notifacations;
	}



	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	
	public String getTypeUser() {
		return typeUser;
	}
	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

}
