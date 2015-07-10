package controller.service;

import models.User;

import java.util.*;

public interface UserService {
	
	User connexion(String login, String pass);
	void deconnexion(String token);
	void inscription(User userTmp);
	User initialise(String token);
	void majUser(User userTmp);
	List<List<User>> getStat();
	void modification(String login, String nom, String prenom, String service, String email);
	void suppression(String login);
	

}
