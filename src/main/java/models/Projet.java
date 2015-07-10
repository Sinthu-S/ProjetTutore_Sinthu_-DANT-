package models;


import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Projet {
	
	@Id
	public String nom;
	public String nomClient;
	public String nomManager;
	public List<Task> listIdTask;
	
	public Projet(String client){
		this.nomClient=client;
		this.nomManager=null;
		this.setListIdTask(new ArrayList<Task>());
	}
	
	public Projet(){
		
	}
	
	public Projet(String nom, String client, String manager){
		this.nom=nom;
		this.nomClient=client;
		this.nomManager=manager;
		this.listIdTask=new ArrayList<Task>();
	}
	
	public String getIdClient() {
		return nomClient;
	}
	public void setIdClient(String idClient) {
		this.nomClient = idClient;
	}
	public String getIdManager() {
		return nomManager;
	}
	public void setIdManager(String idManager) {
		this.nomManager = idManager;
	}

	public List<Task> getListIdTask() {
		return listIdTask;
	}

	public void setListIdTask(List<Task> listIdTask) {
		this.listIdTask = listIdTask;
	}
	
	

	@Override
	public String toString() {
		return "Projet [id= nom=" + nom + ", nomClient=" + nomClient
				+ ", nomManager=" + nomManager + ", listIdTask=" + listIdTask
				+ "]";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
}
