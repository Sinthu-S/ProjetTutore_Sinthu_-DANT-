package controller.service;

import java.util.List;

import models.Projet;
import models.Task;

public interface ProjetService {

	void ajoutProjet(Projet p);
	List<Projet> projetParClient(String nomclient);
	List<Projet> projetParManager(String nommanager);
	List<Projet> projetsGet();
	void ajoutDemande(String projet, Task t);
	void majProjet(Projet p);
	void majProjet(String nomprojet, int i, String nom, String comment,
			int progress, String dev);
	void majProjet(String nomprojet, int i, String nom, String comment,
			int progress);
	

}
