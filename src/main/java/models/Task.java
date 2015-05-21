package models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;


public class Task {
	@Id
	public String id;

	private String titre;
	private String description;
	private String service;
	private String techno;
	private List<String> commentaires;
	
	public Task(){
		commentaires = new ArrayList<String>();
		
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getTechno() {
		return techno;
	}
	public void setTechno(String techno) {
		this.techno = techno;
	}
	public List<String> getCommentaire() {
		return this.commentaires;
	}
	public void setCommentaire(List<String> commentaire) {
		this.commentaires = commentaire;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	

}
