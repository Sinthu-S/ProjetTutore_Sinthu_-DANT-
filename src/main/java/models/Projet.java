package models;


import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Projet {
	
	@Id
	private String id;
	
	private String idClient;
	private String idManager;
	private List<String> listIdTask;
	
	public Projet(String client){
		this.idClient=client;
		this.idManager=null;
		this.setListIdTask(new ArrayList<String>());
	}
	
	public Projet(){
		
	}
	
	public Projet(String client, String manager){
		this.idClient=client;
		this.idManager=manager;
		this.listIdTask=new ArrayList<String>();
	}
	
	public String getIdClient() {
		return idClient;
	}
	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}
	public String getIdManager() {
		return idManager;
	}
	public void setIdManager(String idManager) {
		this.idManager = idManager;
	}

	public List<String> getListIdTask() {
		return listIdTask;
	}

	public void setListIdTask(List<String> listIdTask) {
		this.listIdTask = listIdTask;
	}
	
	@Override
    public String toString() {
        return String.format(
                "Custome");
    }
	
	
	
}
