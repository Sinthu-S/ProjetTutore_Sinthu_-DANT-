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
	private List<String> idProjet;
	private List<String> notifacations;
	
	public User(){
		super();
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
