package controller.service;

import java.util.List;

import models.Projet;

public interface ProjetService {

	void save(Projet p);

	Projet find(String id);

}
