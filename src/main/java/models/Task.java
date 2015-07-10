package models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;


public class Task {
	@Id
	public String id;

	public String titre;
	public String description;
	public String service;
	public String techno;
	public int etat;
	public List<Message> commentaires;
	public String  loginDevloppeur;
	
	public Task(){
		commentaires = new ArrayList<Message>();
		
	}
	
	public Task( String titre, String description, String service,
			String techno) {
		super();
		this.titre = titre;
		this.description = description;
		this.service = service;
		this.techno = techno;
		
		this.commentaires = new ArrayList<Message>();
		this.etat=0;
	}
	
	

	@Override
	public String toString() {
		return "Task [id=" + id + ", titre=" + titre + ", description="
				+ description + ", service=" + service + ", techno=" + techno
				+ ", etat=" + etat + ", commentaires=" + commentaires
				+ ", loginDevloppeur=" + loginDevloppeur + "]";
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
	public List<Message> getCommentaire() {
		return this.commentaires;
	}
	public void setCommentaire(List<Message> commentaire) {
		this.commentaires = commentaire;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getLoginDevloppeur() {
		return loginDevloppeur;
	}

	public void setLoginDevloppeur(String loginDevloppeur) {
		this.loginDevloppeur = loginDevloppeur;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}
	

}
