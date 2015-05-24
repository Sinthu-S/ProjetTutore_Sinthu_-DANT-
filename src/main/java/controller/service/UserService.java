package controller.service;

import models.User;

public interface UserService {
	
	User connexion(String login, String pass);
	void inscription(User userTmp);
	User initialise(String token);
	void majUser(User userTmp);

}
