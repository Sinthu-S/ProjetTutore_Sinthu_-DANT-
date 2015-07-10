package controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import controller.repository.ProjetRepository;
import controller.repository.UserRepository;
import models.Message;
import models.Projet;
import models.Task;
import models.User;

@Service
public class MongoProjetService implements ProjetService {
	
	private final ProjetRepository dao;
	private final UserRepository daoUser;

	@Autowired
    MongoProjetService(ProjetRepository repository, UserRepository daoUser) {
        this.dao = repository;
        this.daoUser=daoUser;
    }

	@Override
	public void ajoutProjet(Projet p) {
		this.dao.save(p);
	}


	@Override
	public List<Projet> projetParClient(String nomclient) {
		return this.dao.findByNomClient(nomclient);
	}

	@Override
	public List<Projet> projetParManager(String nommanager) {
		return this.dao.findByNomManager(nommanager);
	}

	@Override
	public List<Projet> projetsGet() {
		return this.dao.findAll();
	}

	@Override
	public void ajoutDemande(String projet, Task t) {
		Projet tmp = this.dao.findOneByNom(projet);
		System.out.println(tmp);
		tmp.listIdTask.add(t);
		this.dao.save(tmp);
		String[] noms=tmp.nomManager.split(" ");
		User u=this.daoUser.findOneByNomAndPrenom(noms[0], noms[1]);
		u.notifications.add(new Message(projet, "Nouvelle demande"));
		this.daoUser.save(u);
		
	}

	@Override
	public void majProjet(Projet p) {
		this.dao.save(p);
		
	}

	@Override
	public void majProjet(String nomprojet, int i, String nom, String comment,
			int progress, String dev) {
		Projet tmp =this.dao.findOneByNom(nomprojet);
		System.out.println(nom+ " "+ tmp);
		tmp.getListIdTask().get(i).getCommentaire().add(new Message(nom,comment));
		tmp.getListIdTask().get(i).setEtat(progress);
		tmp.getListIdTask().get(i).setLoginDevloppeur(dev);
		this.dao.save(tmp);
	}
	
	@Override
	public void majProjet(String nomprojet, int i, String nom, String comment,
			int progress) {
		Projet tmp =this.dao.findOneByNom(nomprojet);
		System.out.println(nom+ " "+ tmp);
		tmp.getListIdTask().get(i).getCommentaire().add(new Message(nom,comment));
		tmp.getListIdTask().get(i).setEtat(progress);
			this.dao.save(tmp);
	}

}
