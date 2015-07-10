package controller.service;

import java.util.List;

import models.Developpeur;
import models.User;

public interface DeveloppeurService {
	
	List<Developpeur> listDev(String loginManager);
	void ajoutDev(Developpeur dev);
}
