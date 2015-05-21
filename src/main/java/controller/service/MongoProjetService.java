package controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import controller.repository.ProjetRepository;
import models.Projet;

@Service
public class MongoProjetService implements ProjetService {
	
	private final ProjetRepository dao;

	@Autowired
    MongoProjetService(ProjetRepository repository) {
        this.dao = repository;
    }

	@Override
	public void save(Projet p) {
		dao.save(p);
		System.out.println(" Service");
		
	}
	
	public Projet find(String id){
		return dao.findByidClient(id);
	}
}
