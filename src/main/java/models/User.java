package models;

import java.util.*;

import org.springframework.data.annotation.Id;

public class User {
	@Id
	public String id;
	
	private String nom;
	private String prenom;
	private String service;
	private String typeUser;
	private String login;
	private String pass;
	private List<String> idProjet;
	private List<String> notifacations;
	public String token;
	
	public User(){
		super();
	}
	
	
	
	public User(String nom, String prenom, String service,
			String typeUser, String login, String pass, List<String> idProjet,
			List<String> notifacations) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.service = service;
		this.typeUser = typeUser;
		this.login = login;
		this.pass = pass;
		this.idProjet = idProjet;
		this.notifacations = notifacations;
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
	
	

}
