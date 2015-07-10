package models;

public class Developpeur extends User{
	
	public String loginmanager;
	
	

	public Developpeur() {
		super();
	}

	public Developpeur(String loginManager) {
		super();
		this.loginmanager = loginManager;
	}

	public String getLoginManager() {
		return loginmanager;
	}

	public void setLoginManager(String loginManager) {
		this.loginmanager = loginManager;
	}
	
	

}
